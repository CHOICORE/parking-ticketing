package me.choicore.samples.parking.ticket

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import java.time.LocalDateTime

class TicketingControllerTests {
    @Nested
    @SpringBootTest
    @AutoConfigureMockMvc
    @TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
    inner class IntegrationTests(
        val mockMvc: MockMvc,
        val objectMapper: ObjectMapper,
    ) {
        @Test
        fun t1() {
            val request =
                TicketingRequest.Automatic(
                    lpn = "1234가3456",
                    src = "lpr-01",
                    ts = LocalDateTime.now(),
                )

            mockMvc
                .post("/v1/tickets") {
                    contentType = MediaType.APPLICATION_JSON
                    accept = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(request)
                }.andExpect {
                    status { isBadRequest() }
                    content {
                        contentType(MediaType.APPLICATION_PROBLEM_JSON)
                    }
                }
        }
    }
}
