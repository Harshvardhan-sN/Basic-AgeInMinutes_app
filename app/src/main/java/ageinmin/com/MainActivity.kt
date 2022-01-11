package ageinmin.com

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private var t1id: TextView? = null
    private var t2id: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         // val btn1: Button = findViewById(R.id.Bt01id)
        val btn1: Button =findViewById(R.id.Bt01id)
        t1id = findViewById(R.id.selectMyDate)
        t2id = findViewById(R.id.calAgeMin)

        btn1.setOnClickListener {
            picDate()
        }
    }

    private fun picDate(){
        val myCalender = Calendar.getInstance()
        val year1 = myCalender.get(Calendar.YEAR)
        val month1 = myCalender.get(Calendar.MONTH)
        val day1 = myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this, {
                _, selectedYear, selectedMonth, selectedDay ->

            // Enter your name by EDITTEXT for toast
            val text1 = findViewById<EditText>(R.id.tv1)
            val name = text1.text.toString().trim()

            val setDate = "$selectedDay/${selectedMonth+1}/$selectedYear"

            t1id?.text = setDate

            val dateFormat = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val finalDate = dateFormat.parse(setDate)

            val selectMin = finalDate!!.time / 60000
            val curDate = dateFormat.parse(dateFormat.format(System.currentTimeMillis()))
            val curDateMin = curDate!!.time / 60000

            val diffMin = curDateMin-selectMin

            t2id?.text = diffMin.toString()

            Toast.makeText(this,"Hello $name!",Toast.LENGTH_LONG).show()


        },year1,month1,day1)

        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()
    }


}

