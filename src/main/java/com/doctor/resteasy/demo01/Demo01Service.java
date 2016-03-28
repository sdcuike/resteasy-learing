package com.doctor.resteasy.demo01;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.doctor.resteasy.common.ModelResult;

/**
 * @author sdcuike
 *
 *         Create At 2016年3月28日
 */
@Path("/demo01")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public interface Demo01Service {

    @POST
    @Path("/getMessage")
    ModelResult<String> getMessage(Demo01Request demo01Request);
}
