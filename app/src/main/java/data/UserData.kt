package data


import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.io.Serializable

data class UserData(


    val texttest : String

){

override fun equals(other: Any?): Boolean {
    return this.texttest == (other as? String)
}

override fun hashCode(): Int {
    return 5
}}