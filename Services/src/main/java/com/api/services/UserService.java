package com.api.services;


import com.recaptcha.interfaces.IRecaptchaManager;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;


@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
public class UserService {

    @Inject
    IRecaptchaManager recaptchaManager;

	@POST
	@Path("/verify/recaptcha")
    public Response verifyRecaptchaToken(@NotNull String recaptchaToken)
    {
        try {
            return  Response.ok(this.recaptchaManager.verify(recaptchaToken)).build();
        } catch (IOException | InterruptedException e){
            Response.serverError().build();
        }
        return Response.serverError().build();
    }
	
	@GET
	@Path("/test")
    public String test()
    {
        return "test hat funktioniert";
    }
}
