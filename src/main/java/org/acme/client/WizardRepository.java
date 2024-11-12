package org.acme.client;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8080/wizard-server")
public interface WizardRepository {

  @GET
  @Path("/start")
  String start();

  @GET
  @Path("/step_1")
  Uni<String> step1();

  @GET
  @Path("/step_2")
  Uni<String> step2();

  @GET
  @Path("/step_3")
  Uni<String> step3();

  @GET
  @Path("/complete")
  String complete();
}