package org.group.ventis.emftontine.stock.resource;

import org.group.ventis.emftontine.stock.entity.Approvisionnement;
import org.group.ventis.emftontine.dto.ApprovisionnementDto;
import org.group.ventis.emftontine.stock.service.ApprovisionnementService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("api/stock/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApprovisionnementResource {

    @Inject
    ApprovisionnementService approvisionnementService;

    @POST
    @Path("create/")
//    @RolesAllowed("admin")
    public ApprovisionnementDto create(ApprovisionnementDto approvisionnement){
        System.out.println(approvisionnement);
        ApprovisionnementDto a = approvisionnementService.create(approvisionnement);
        if (a != null )
            return a;
        else
            return null;
    }

}
