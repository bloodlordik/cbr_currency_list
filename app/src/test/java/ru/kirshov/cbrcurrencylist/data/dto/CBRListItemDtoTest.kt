package ru.kirshov.cbrcurrencylist.data.dto
import com.google.common.truth.Truth.assertThat
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test


class CBRListItemDtoTest{
    private fun rawTestData():String{
        return "{\n" +
                "    \"Date\": \"2022-05-14T11:30:00+03:00\",\n" +
                "    \"PreviousDate\": \"2022-05-13T11:30:00+03:00\",\n" +
                "    \"PreviousURL\": \"\\/\\/www.cbr-xml-daily.ru\\/archive\\/2022\\/05\\/13\\/daily_json.js\",\n" +
                "    \"Timestamp\": \"2022-05-16T11:00:00+03:00\",\n" +
                "    \"Valute\": {\n" +
                "        \"AUD\": {\n" +
                "            \"ID\": \"R01010\",\n" +
                "            \"NumCode\": \"036\",\n" +
                "            \"CharCode\": \"AUD\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Австралийский доллар\",\n" +
                "            \"Value\": 43.9954,\n" +
                "            \"Previous\": 45.258\n" +
                "        },\n" +
                "        \"AZN\": {\n" +
                "            \"ID\": \"R01020A\",\n" +
                "            \"NumCode\": \"944\",\n" +
                "            \"CharCode\": \"AZN\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Азербайджанский манат\",\n" +
                "            \"Value\": 37.5176,\n" +
                "            \"Previous\": 38.7009\n" +
                "        },\n" +
                "        \"GBP\": {\n" +
                "            \"ID\": \"R01035\",\n" +
                "            \"NumCode\": \"826\",\n" +
                "            \"CharCode\": \"GBP\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Фунт стерлингов Соединенного королевства\",\n" +
                "            \"Value\": 77.9901,\n" +
                "            \"Previous\": 81.1868\n" +
                "        },\n" +
                "        \"AMD\": {\n" +
                "            \"ID\": \"R01060\",\n" +
                "            \"NumCode\": \"051\",\n" +
                "            \"CharCode\": \"AMD\",\n" +
                "            \"Nominal\": 100,\n" +
                "            \"Name\": \"Армянских драмов\",\n" +
                "            \"Value\": 13.9887,\n" +
                "            \"Previous\": 14.0921\n" +
                "        },\n" +
                "        \"BYN\": {\n" +
                "            \"ID\": \"R01090B\",\n" +
                "            \"NumCode\": \"933\",\n" +
                "            \"CharCode\": \"BYN\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Белорусский рубль\",\n" +
                "            \"Value\": 25.0865,\n" +
                "            \"Previous\": 25.8778\n" +
                "        },\n" +
                "        \"BGN\": {\n" +
                "            \"ID\": \"R01100\",\n" +
                "            \"NumCode\": \"975\",\n" +
                "            \"CharCode\": \"BGN\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Болгарский лев\",\n" +
                "            \"Value\": 33.9399,\n" +
                "            \"Previous\": 35.4997\n" +
                "        },\n" +
                "        \"BRL\": {\n" +
                "            \"ID\": \"R01115\",\n" +
                "            \"NumCode\": \"986\",\n" +
                "            \"CharCode\": \"BRL\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Бразильский реал\",\n" +
                "            \"Value\": 12.3895,\n" +
                "            \"Previous\": 12.8396\n" +
                "        },\n" +
                "        \"HUF\": {\n" +
                "            \"ID\": \"R01135\",\n" +
                "            \"NumCode\": \"348\",\n" +
                "            \"CharCode\": \"HUF\",\n" +
                "            \"Nominal\": 100,\n" +
                "            \"Name\": \"Венгерских форинтов\",\n" +
                "            \"Value\": 17.2836,\n" +
                "            \"Previous\": 17.9518\n" +
                "        },\n" +
                "        \"HKD\": {\n" +
                "            \"ID\": \"R01200\",\n" +
                "            \"NumCode\": \"344\",\n" +
                "            \"CharCode\": \"HKD\",\n" +
                "            \"Nominal\": 10,\n" +
                "            \"Name\": \"Гонконгских долларов\",\n" +
                "            \"Value\": 81.3934,\n" +
                "            \"Previous\": 83.9607\n" +
                "        },\n" +
                "        \"DKK\": {\n" +
                "            \"ID\": \"R01215\",\n" +
                "            \"NumCode\": \"208\",\n" +
                "            \"CharCode\": \"DKK\",\n" +
                "            \"Nominal\": 10,\n" +
                "            \"Name\": \"Датских крон\",\n" +
                "            \"Value\": 89.2076,\n" +
                "            \"Previous\": 93.328\n" +
                "        },\n" +
                "        \"USD\": {\n" +
                "            \"ID\": \"R01235\",\n" +
                "            \"NumCode\": \"840\",\n" +
                "            \"CharCode\": \"USD\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Доллар США\",\n" +
                "            \"Value\": 63.7799,\n" +
                "            \"Previous\": 65.7916\n" +
                "        },\n" +
                "        \"EUR\": {\n" +
                "            \"ID\": \"R01239\",\n" +
                "            \"NumCode\": \"978\",\n" +
                "            \"CharCode\": \"EUR\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Евро\",\n" +
                "            \"Value\": 65.7939,\n" +
                "            \"Previous\": 68.7835\n" +
                "        },\n" +
                "        \"INR\": {\n" +
                "            \"ID\": \"R01270\",\n" +
                "            \"NumCode\": \"356\",\n" +
                "            \"CharCode\": \"INR\",\n" +
                "            \"Nominal\": 100,\n" +
                "            \"Name\": \"Индийских рупий\",\n" +
                "            \"Value\": 83.1041,\n" +
                "            \"Previous\": 86.467\n" +
                "        },\n" +
                "        \"KZT\": {\n" +
                "            \"ID\": \"R01335\",\n" +
                "            \"NumCode\": \"398\",\n" +
                "            \"CharCode\": \"KZT\",\n" +
                "            \"Nominal\": 100,\n" +
                "            \"Name\": \"Казахстанских тенге\",\n" +
                "            \"Value\": 14.6701,\n" +
                "            \"Previous\": 14.8645\n" +
                "        },\n" +
                "        \"CAD\": {\n" +
                "            \"ID\": \"R01350\",\n" +
                "            \"NumCode\": \"124\",\n" +
                "            \"CharCode\": \"CAD\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Канадский доллар\",\n" +
                "            \"Value\": 48.9147,\n" +
                "            \"Previous\": 50.726\n" +
                "        },\n" +
                "        \"KGS\": {\n" +
                "            \"ID\": \"R01370\",\n" +
                "            \"NumCode\": \"417\",\n" +
                "            \"CharCode\": \"KGS\",\n" +
                "            \"Nominal\": 100,\n" +
                "            \"Name\": \"Киргизских сомов\",\n" +
                "            \"Value\": 76.8094,\n" +
                "            \"Previous\": 79.5795\n" +
                "        },\n" +
                "        \"CNY\": {\n" +
                "            \"ID\": \"R01375\",\n" +
                "            \"NumCode\": \"156\",\n" +
                "            \"CharCode\": \"CNY\",\n" +
                "            \"Nominal\": 10,\n" +
                "            \"Name\": \"Китайских юаней\",\n" +
                "            \"Value\": 93.6542,\n" +
                "            \"Previous\": 96.905\n" +
                "        },\n" +
                "        \"MDL\": {\n" +
                "            \"ID\": \"R01500\",\n" +
                "            \"NumCode\": \"498\",\n" +
                "            \"CharCode\": \"MDL\",\n" +
                "            \"Nominal\": 10,\n" +
                "            \"Name\": \"Молдавских леев\",\n" +
                "            \"Value\": 33.7174,\n" +
                "            \"Previous\": 34.8637\n" +
                "        },\n" +
                "        \"NOK\": {\n" +
                "            \"ID\": \"R01535\",\n" +
                "            \"NumCode\": \"578\",\n" +
                "            \"CharCode\": \"NOK\",\n" +
                "            \"Nominal\": 10,\n" +
                "            \"Name\": \"Норвежских крон\",\n" +
                "            \"Value\": 64.5128,\n" +
                "            \"Previous\": 68.2068\n" +
                "        },\n" +
                "        \"PLN\": {\n" +
                "            \"ID\": \"R01565\",\n" +
                "            \"NumCode\": \"985\",\n" +
                "            \"CharCode\": \"PLN\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Польский злотый\",\n" +
                "            \"Value\": 14.1115,\n" +
                "            \"Previous\": 14.6804\n" +
                "        },\n" +
                "        \"RON\": {\n" +
                "            \"ID\": \"R01585F\",\n" +
                "            \"NumCode\": \"946\",\n" +
                "            \"CharCode\": \"RON\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Румынский лей\",\n" +
                "            \"Value\": 13.387,\n" +
                "            \"Previous\": 13.8731\n" +
                "        },\n" +
                "        \"XDR\": {\n" +
                "            \"ID\": \"R01589\",\n" +
                "            \"NumCode\": \"960\",\n" +
                "            \"CharCode\": \"XDR\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"СДР (специальные права заимствования)\",\n" +
                "            \"Value\": 85.0154,\n" +
                "            \"Previous\": 88.095\n" +
                "        },\n" +
                "        \"SGD\": {\n" +
                "            \"ID\": \"R01625\",\n" +
                "            \"NumCode\": \"702\",\n" +
                "            \"CharCode\": \"SGD\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Сингапурский доллар\",\n" +
                "            \"Value\": 45.7269,\n" +
                "            \"Previous\": 47.2879\n" +
                "        },\n" +
                "        \"TJS\": {\n" +
                "            \"ID\": \"R01670\",\n" +
                "            \"NumCode\": \"972\",\n" +
                "            \"CharCode\": \"TJS\",\n" +
                "            \"Nominal\": 10,\n" +
                "            \"Name\": \"Таджикских сомони\",\n" +
                "            \"Value\": 51.0443,\n" +
                "            \"Previous\": 52.6543\n" +
                "        },\n" +
                "        \"TRY\": {\n" +
                "            \"ID\": \"R01700J\",\n" +
                "            \"NumCode\": \"949\",\n" +
                "            \"CharCode\": \"TRY\",\n" +
                "            \"Nominal\": 10,\n" +
                "            \"Name\": \"Турецких лир\",\n" +
                "            \"Value\": 41.5061,\n" +
                "            \"Previous\": 42.9957\n" +
                "        },\n" +
                "        \"TMT\": {\n" +
                "            \"ID\": \"R01710A\",\n" +
                "            \"NumCode\": \"934\",\n" +
                "            \"CharCode\": \"TMT\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Новый туркменский манат\",\n" +
                "            \"Value\": 18.2228,\n" +
                "            \"Previous\": 18.7976\n" +
                "        },\n" +
                "        \"UZS\": {\n" +
                "            \"ID\": \"R01717\",\n" +
                "            \"NumCode\": \"860\",\n" +
                "            \"CharCode\": \"UZS\",\n" +
                "            \"Nominal\": 10000,\n" +
                "            \"Name\": \"Узбекских сумов\",\n" +
                "            \"Value\": 57.1201,\n" +
                "            \"Previous\": 58.8232\n" +
                "        },\n" +
                "        \"UAH\": {\n" +
                "            \"ID\": \"R01720\",\n" +
                "            \"NumCode\": \"980\",\n" +
                "            \"CharCode\": \"UAH\",\n" +
                "            \"Nominal\": 10,\n" +
                "            \"Name\": \"Украинских гривен\",\n" +
                "            \"Value\": 21.6002,\n" +
                "            \"Previous\": 22.2656\n" +
                "        },\n" +
                "        \"CZK\": {\n" +
                "            \"ID\": \"R01760\",\n" +
                "            \"NumCode\": \"203\",\n" +
                "            \"CharCode\": \"CZK\",\n" +
                "            \"Nominal\": 10,\n" +
                "            \"Name\": \"Чешских крон\",\n" +
                "            \"Value\": 26.6271,\n" +
                "            \"Previous\": 27.3744\n" +
                "        },\n" +
                "        \"SEK\": {\n" +
                "            \"ID\": \"R01770\",\n" +
                "            \"NumCode\": \"752\",\n" +
                "            \"CharCode\": \"SEK\",\n" +
                "            \"Nominal\": 10,\n" +
                "            \"Name\": \"Шведских крон\",\n" +
                "            \"Value\": 63.1415,\n" +
                "            \"Previous\": 64.93\n" +
                "        },\n" +
                "        \"CHF\": {\n" +
                "            \"ID\": \"R01775\",\n" +
                "            \"NumCode\": \"756\",\n" +
                "            \"CharCode\": \"CHF\",\n" +
                "            \"Nominal\": 1,\n" +
                "            \"Name\": \"Швейцарский франк\",\n" +
                "            \"Value\": 63.7608,\n" +
                "            \"Previous\": 66.0293\n" +
                "        },\n" +
                "        \"ZAR\": {\n" +
                "            \"ID\": \"R01810\",\n" +
                "            \"NumCode\": \"710\",\n" +
                "            \"CharCode\": \"ZAR\",\n" +
                "            \"Nominal\": 10,\n" +
                "            \"Name\": \"Южноафриканских рэндов\",\n" +
                "            \"Value\": 39.7787,\n" +
                "            \"Previous\": 40.5583\n" +
                "        },\n" +
                "        \"KRW\": {\n" +
                "            \"ID\": \"R01815\",\n" +
                "            \"NumCode\": \"410\",\n" +
                "            \"CharCode\": \"KRW\",\n" +
                "            \"Nominal\": 1000,\n" +
                "            \"Name\": \"Вон Республики Корея\",\n" +
                "            \"Value\": 49.6651,\n" +
                "            \"Previous\": 51.0567\n" +
                "        },\n" +
                "        \"JPY\": {\n" +
                "            \"ID\": \"R01820\",\n" +
                "            \"NumCode\": \"392\",\n" +
                "            \"CharCode\": \"JPY\",\n" +
                "            \"Nominal\": 100,\n" +
                "            \"Name\": \"Японских иен\",\n" +
                "            \"Value\": 49.4801,\n" +
                "            \"Previous\": 50.7103\n" +
                "        }\n" +
                "    }\n" +
                "}"
    }
    @Test fun serializeTest(){
        val actual = Json.decodeFromString<CBRListItemDto>(rawTestData())
        assertThat(actual.date).isEqualTo("2022-05-14T11:30:00+03:00")
        assertThat(actual.currencyList).containsKey("AUD")
        val item = actual.currencyList["AUD"]!!
        assertThat(item.value).isEqualTo(43.9954)
    }
}