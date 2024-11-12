package org.acme.server;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.concurrent.TimeUnit;

@Path("/wizard-server")
public class WizardServerResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/start")
  public String start() {
    return response(2, "start");
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/step_1")
  public String step1() {
    return response(1, "step_1");
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/step_2")
  public String step2() {
    return response(1, "step_2");
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/step_3")
  public String step3() {
    return response(3, "step_3");
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/complete")
  public String complete() {
    return response(1, "complete");
  }

  private String response(long timeout, String step) {
    try {
      TimeUnit.SECONDS.sleep(timeout);
    } catch (InterruptedException ignored) {
    }
    return step + " - OK";
  }
}
