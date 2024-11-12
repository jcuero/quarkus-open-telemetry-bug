package org.acme.client;


import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class WizardService {

  private final WizardRepository wizardRepository;

  public WizardService(@RestClient WizardRepository wizardRepository) {
    this.wizardRepository = wizardRepository;
  }

  public void process() {
    this.wizardRepository.start();

    List<Uni<String>> steps = List.of(
        this.wizardRepository.step1(),
        this.wizardRepository.step2(),
        this.wizardRepository.step3()
    );

    Uni.combine().all().unis(steps).with(objects -> {
      System.out.println("All steps completed: " + objects);
      return objects;
    }).await().indefinitely();

    this.wizardRepository.complete();
  }
}