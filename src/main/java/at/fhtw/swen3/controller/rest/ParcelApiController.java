package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.IOException;
import java.util.Optional;
import javax.annotation.Generated;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

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
    public ResponseEntity<NewParcelInfo> submitParcel(
            @Parameter(name = "Parcel", description = "", required = true) @Valid @RequestBody Parcel parcel
    ){
        try{
            String trackingId = parcelService.submitParcel(parcel);
            String message = String.format("{ \"trackingId\" : \"%s\" }",trackingId);
            ApiUtil.setExampleResponse(request, "application/json", message);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (IOException | InterruptedException e){
            String errorMessage = String.format("{ \"error\" : \"%s\" }",e.getMessage());
            ApiUtil.setExampleResponse(request, "application/json", errorMessage);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            String errorMessage = String.format("{ \"error\" : \"%s\" }",e.getMessage());
            ApiUtil.setExampleResponse(request, "application/json", errorMessage);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
