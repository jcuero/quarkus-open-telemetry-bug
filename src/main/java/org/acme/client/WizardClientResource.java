package org.acme.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/wizard-client")
public class WizardClientResource {

  private final WizardService wizardService;

  public WizardClientResource(WizardService wizardService) {
    this.wizardService = wizardService;
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/work")
  public String work() {
    this.wizardService.process();
    return "Work done!";
  }
}
