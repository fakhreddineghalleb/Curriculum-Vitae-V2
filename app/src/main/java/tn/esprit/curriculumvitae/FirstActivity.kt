package tn.esprit.curriculumvitae

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


const val FULL_NAME = "FULL_NAME"
const val GENDER = "GENDER"
const val AGE = "AGE"
const val EMAIL = "EMAIL"
const val IMAGE = "IMAGE"

class FirstActivity : AppCompatActivity() {

    private var profilePic: ImageView? = null

    private var txtFullName: TextInputEditText? = null
    private var txtAge: TextInputEditText? = null
    private var txtEmail: TextInputEditText? = null

    private var txtLayoutFullName: TextInputLayout? = null
    private var txtLayoutAge: TextInputLayout? = null
    private var txtLayoutEmail: TextInputLayout? = null

    private var rbMale: RadioButton? = null
    private var rbFemale: RadioButton? = null

    private var btnNext: Button? = null

    private var selectedImageUri: Uri? = null

    private val startForResultOpenGallery = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            selectedImageUri = result.data!!.data
            profilePic!!.setImageURI(selectedImageUri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        title = getString(R.string.createYourResume)

        profilePic = findViewById(R.id.profilePic)

        txtFullName = findViewById(R.id.txtFullName)
        txtAge = findViewById(R.id.txtAge)
        txtEmail = findViewById(R.id.txtEmail)

        txtLayoutFullName = findViewById(R.id.txtLayoutFullName)
        txtLayoutAge = findViewById(R.id.txtLayoutAge)
        txtLayoutEmail = findViewById(R.id.txtLayoutEmail)

        rbMale = findViewById(R.id.rbMale)
        rbFemale = findViewById(R.id.rbFemale)
        btnNext = findViewById(R.id.btnNext)

        profilePic!!.setOnClickListener{
            openGallery()
        }

        btnNext!!.setOnClickListener {
            clickNext()
        }
    }

    private fun openGallery(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startForResultOpenGallery.launch(intent)
    }

    private fun clickNext() {
        if(validate()){
            if (selectedImageUri != null) {
                val mainIntent = Intent(this, SecondActivity::class.java).apply {
                    putExtra(FULL_NAME, txtFullName!!.text.toString())
                    putExtra(AGE, txtAge!!.text.toString())
                    putExtra(EMAIL, txtEmail!!.text.toString())
                    putExtra(IMAGE, selectedImageUri.toString())
                    if (rbMale!!.isChecked)
                        putExtra(GENDER, rbMale!!.text.toString())
                    if (rbFemale!!.isChecked)
                        putExtra(GENDER, rbFemale!!.text.toString())
                }
                startActivity(mainIntent)
            }else{
                Toast.makeText(this, "Please select an image !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validate(): Boolean {
        txtLayoutFullName!!.error = null
        txtLayoutEmail!!.error = null
        txtLayoutAge!!.error = null

        if (txtFullName?.text!!.isEmpty()){
            txtLayoutFullName!!.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        if (txtFullName?.length()!! < 3){
            txtLayoutFullName!!.error = getString(R.string.mustBeAtLeast3)
            return false
        }

        if (txtEmail?.text!!.isEmpty()){
            txtLayoutEmail!!.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        if(!EMAIL_ADDRESS.matcher(txtEmail?.text!!).matches()){
            txtLayoutEmail!!.error = getString(R.string.checkYourEmail)
            return false
        }

        if (txtAge?.text!!.isEmpty()){
            txtLayoutAge!!.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        return true
    }
}