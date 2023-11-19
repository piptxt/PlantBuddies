package oldkotlinfiles.oldkotlinfiles

import androidx.appcompat.app.AppCompatActivity
import com.mobedeve.plantbuddy.databinding.ActivityNotesViewNoteBinding

class NotesViewNoteActivity : AppCompatActivity() {

    companion object {
        const val titleKey : String = "TITLE_KEY"
        const val bodyKey : String = "BODY_KEY"
        const val positionKey: String = "POSITION_KEY"
    }

    private lateinit var titleString: String
    private lateinit var bodyString: String

    private lateinit var viewBinding: ActivityNotesViewNoteBinding
}