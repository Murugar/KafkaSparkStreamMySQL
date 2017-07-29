
package com.iqmsoft.spark.kafka.mysql.http.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.iqmsoft.spark.kafka.mysql.http.responses.MessageResponse;
import com.iqmsoft.spark.kafka.mysql.http.utils.ResponseUtils;
import com.iqmsoft.spark.kafka.mysql.http.utils.Types;
import com.iqmsoft.spark.kafka.mysql.http.utils.ViewUtils;

@Path("/")
public class MainResource {
    @GET
    @Produces(Types.HTML)
    public Response getMainPage() {
        try {
            return Response.ok().entity(ViewUtils.render("main")).build();
        } catch (IOException e) {
            return Response.serverError()
                    .entity(ResponseUtils.toJson(new MessageResponse(false, e.getMessage())))
                    .build();
        }
    }
}