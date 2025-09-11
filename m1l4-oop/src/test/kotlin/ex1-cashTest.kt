import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale
import kotlin.test.Test
import kotlin.test.assertEquals

class Cash(
    val amount: BigDecimal,
    private val currency: Currency
) {
    constructor(
        amount: String,
        currency: Currency
    ) : this(BigDecimal(amount), currency)

    fun format(locale: Locale): String {
        val formatter = NumberFormat.getCurrencyInstance(locale)
        formatter.currency = currency
        return formatter.format(amount)
    }

    operator fun minus(other: Cash): Cash {
        require(currency == other.currency) {
            "Summand should be of the same currency"
        }
        return Cash(amount - other.amount, currency)
    }

    companion object {
        val NONE = Cash(BigDecimal.ZERO, Currency.getInstance("RUR"))
    }
}

class CashTest {
    @Test
    fun test() {
        val a = Cash("10", Currency.getInstance("USD"))
        val b = Cash("20", Currency.getInstance("USD"))
        val c = b - a
        //c.amount = BigDecimal.TEN; // ERROR!
        println(c.amount)
        println(a)
        println(c.format(Locale.FRANCE))

        assertEquals(c.amount, BigDecimal.TEN)

        @Suppress("RedundantCompanionReference")
        assertEquals(Cash.Companion.NONE, Cash.NONE)
    }
}