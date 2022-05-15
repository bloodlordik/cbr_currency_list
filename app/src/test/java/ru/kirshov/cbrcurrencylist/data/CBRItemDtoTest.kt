package ru.kirshov.cbrcurrencylist.data
import com.google.common.truth.Truth.assertThat
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test


class CBRItemDtoTest{
    private fun testString():String{
        return "{\n" +
                "            \"ID\": \"R01010\",\n" +
                "            \"NumCode\": \"036\",\n" +
                "            \"CharCode\": \"AUD\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Австралийский доллар\",\n" +
                "            \"Value\": 43.9954,\n" +
                "            \"Previous\": 45.258\n" +
                "        }"
    }
    private fun expectValue():CBRItemDto{
        return CBRItemDto(
            id = "R01010",
            numCode = "036",
            charCode = "AUD",
            nominal = 1,
            name = "Австралийский доллар",
            value = 43.9954,
            previous = 45.258
        )
    }
    @Test fun simpleTest(){
        val actualValue = Json.decodeFromString<CBRItemDto>(testString())
        assertThat(actualValue).isEqualTo(expectValue())
    }
}