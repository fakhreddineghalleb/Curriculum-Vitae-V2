package tn.esprit.curriculumvitae

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var profilePic: ImageView
    private lateinit var txtFullName: TextView
    private lateinit var txtEmail: TextView

    private lateinit var btnSkills: Button
    private lateinit var btnHobbies: Button
    private lateinit var btnLanguage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.app_bar)
        setSupportActionBar(toolbar)

        title = "Your Resume"

        profilePic = findViewById(R.id.profilePic)
        txtFullName = findViewById(R.id.txtFullName)
        txtEmail = findViewById(R.id.txtEmail)

        btnSkills = findViewById(R.id.btnSkills)
        btnHobbies = findViewById(R.id.btnHobbies)
        btnLanguage = findViewById(R.id.btnLanguage)

        profilePic.setImageURI(Uri.parse(intent.extras!!.getString(IMAGE)))

        txtFullName.text = intent.getStringExtra(FULL_NAME).toString()
        txtEmail.text = intent.getStringExtra(EMAIL).toString()

        btnSkills.setOnClickListener {
            val skillsFragment = SkillsFragment.newInstance(intent.getFloatExtra(SKILL_ANDROID, 0.0F),
                intent.getFloatExtra(SKILL_IOS, 0.0F), intent.getFloatExtra(SKILL_FLUTTER, 0.0F))

            changeFragment(skillsFragment, "")
        }

        btnHobbies.setOnClickListener {
            val hobbiesFragment = HobbiesFragment.newInstance(intent.getBooleanExtra(IS_SPORT, false),
                intent.getBooleanExtra(IS_MUSIC, false),intent.getBooleanExtra(IS_GAMES, false))
            changeFragment(hobbiesFragment, "")
        }

        btnLanguage.setOnClickListener {
            val languageFragment = LanguageFragment.newInstance(intent.getBooleanExtra(IS_ARABIC, false),
                intent.getBooleanExtra(IS_FRENCH, false),intent.getBooleanExtra(IS_ENGLISH, false))
            changeFragment(languageFragment, "")
        }

        val skillsFragment = SkillsFragment.newInstance(intent.getFloatExtra(SKILL_ANDROID, 0.0F),
            intent.getFloatExtra(SKILL_IOS, 0.0F), intent.getFloatExtra(SKILL_FLUTTER, 0.0F))

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, skillsFragment).commit()

    }

    private fun changeFragment(fragment: Fragment, name: String) {

        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        else
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("").commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.info -> {
                val aboutMeFragment = AboutMeFragment.newInstance(intent.getStringExtra(FULL_NAME).toString(),
                    intent.getStringExtra(AGE).toString(), intent.getStringExtra(GENDER).toString(),
                    intent.getStringExtra(EMAIL).toString())
                changeFragment(aboutMeFragment,"AboutMe")
            }
        }

        return super.onOptionsItemSelected(item)
    }
}