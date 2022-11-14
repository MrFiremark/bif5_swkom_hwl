package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.services.ParcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-14T11:21:04.473420Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    private ParcelService parcelService;

    private final NativeWebRequest request;
    @Autowired
    public ParcelApiController(ParcelService parcelService, NativeWebRequest request){
        this.parcelService = parcelService;
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
