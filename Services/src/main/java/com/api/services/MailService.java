package com.api.services;

import com.mail.dto.MailDTO;
import com.mail.interfaces.IMailManager;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("mail")
@Consumes(MediaType.APPLICATION_JSON)
public class MailService {

    @Inject
    IMailManager mailManager;

    @POST
    @Path("/submit")
    public Response verifyRecaptchaToken(@NotNull @Valid MailDTO mailDTO)
    {
        if(this.mailManager.submit(mailDTO)){
            return Response.ok().build();
        }
        return Response.serverError().build();
    }

}
