package mastermind

import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.JsonPathResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class MastermindControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun shouldReturnBadRequestWhenGuessParamNoSpecified() {
        mockMvc.perform(MockMvcRequestBuilders.get("/mastermind/id"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest)
    }

    @Test
    fun shouldReturnOkResponseWhenGuessParamSpecified() {
        mockMvc.perform(MockMvcRequestBuilders.get("/mastermind/id").param("guess[]", "0,0,0,0"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun shouldRememberPreviousMoves() {
        mockMvc.perform(MockMvcRequestBuilders.get("/mastermind/id").param("guess[]", "0,0,0,0"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$.moves", Matchers.hasSize<Move>(1)))
        mockMvc.perform(MockMvcRequestBuilders.get("/mastermind/id").param("guess[]", "0,0,0,0"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$.moves", Matchers.hasSize<Move>(2)))
    }
}