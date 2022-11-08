package at.fhtw.swen3.services;

import at.fhtw.swen3.controller.rest.ParcelApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
class ParcelApiTest {

    @Mock
    ParcelApi mocked;

    @Test
    void getRequest() {
    }

    @Test
    void reportParcelDelivery() {
    }

    @Test
    void reportParcelHop() {
    }

    @Test
    void submitParcel() {
    }

    @Test
    void trackParcel() {
    }

    @Test
    void transitionParcel() {
    }
}