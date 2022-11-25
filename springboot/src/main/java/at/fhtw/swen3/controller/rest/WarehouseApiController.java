package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.WarehouseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-14T15:32:51.812001Z[Etc/UTC]")
@Controller
public class WarehouseApiController implements WarehouseApi {

    private final NativeWebRequest request;

    @Autowired
    public WarehouseApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
