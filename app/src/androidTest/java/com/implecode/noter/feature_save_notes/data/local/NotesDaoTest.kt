package com.implecode.noter.feature_save_notes.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class NotesDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var db: NotesDatabase
    private lateinit var dao: NotesDao

    @Before
    fun setup(){
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NotesDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = db.getNotesDao()
    }

    @After
    fun tearDown(){
        db.close()
    }

    /**
     * Test 1: Notes Dao Save Note Correctly Inside Notes Database
     * */
    @Test
    fun notesDao_InsertsNoteCorrectlyInto_NotesDatabase() = runBlocking {
        val note = NoteEntity(
            1234,
            "Title",
            "Desc",
            false,
            "Car"
        )
        // Step 2: Insert the note
        dao.insertNote(note)

        // Step 3: Assertion
        val notesInsideDatabase = dao.getAllNotes()

        assertThat(notesInsideDatabase).contains(note)
    }

    /**
     * Test 2: Notes Dao Updates Note Correctly Inside Notes Database
     * */
    @Test
    fun notesDao_UpdatesNoteCorrectlyInside_NotesDatabase() = runBlocking {
        val note1 = NoteEntity(
            1234,
            "Title",
            "Desc",
            false,
            "Car"
        )
        // Insert this note
        dao.insertNote(note1)

        val note2 = NoteEntity(
            1234,
            "Changed Title",
            "Changed Desc",
            false,
            "Bike"
        )

        // Insert the note 2
        dao.insertNote(note2)

        // Assertion
        val notesInsideDb = dao.getAllNotes()
        assertThat(notesInsideDb).hasSize(1)
        assertThat(notesInsideDb[0].category).isEqualTo("Bike")

    }

    /**
     * Test 3: Notes Dao Deletes Note Correctly Inside Notes Database
     * */
    @Test
    fun notesDao_DeletesNoteCorrectlyFrom_NotesDatabase() = runBlocking {
        val note = NoteEntity(
            1234,
            "Changed Title",
            "Changed Desc",
            false,
            "Bike"
        )
        val newNote = NoteEntity(
            12344,
            "Changed Title",
            "Changed Desc",
            false,
            "Bike"
        )

        // Insert Note
        dao.insertNote(note)
        dao.insertNote(newNote)

        // delete note
        dao.deleteNote(note)

        // Assert there are no notes inside notes database
        val notesInDb = dao.getAllNotes()
        assertThat(notesInDb).doesNotContain(note)
        assertThat(notesInDb).hasSize(1)
    }


    /**
     * Test 4: Notes Dao Insert Notes In Bulk Correctly Inside Database
     * */
    @Test
    fun notesDao_InsertNotesInBulkCorrectlyInto_NotesDatabase() = runBlocking {
        val notesList = listOf(
            NoteEntity(
                12345,
                "Changed Title",
                "Changed Desc",
                false,
                "Bike"
            ),
            NoteEntity(
                1234,
                "Changed Title",
                "Changed Desc",
                false,
                "Bike"
            ),
            NoteEntity(
                123456,
                "Changed Title",
                "Changed Desc",
                false,
                "Bike"
            ),
            NoteEntity(
                1234,
                "Changed Title",
                "Changed Desc",
                false,
                "Bike"
            )
        )


        // Insert Note
        dao.insertNotes(notesList)


        // Assert there are no notes inside notes database
        val notesInDb = dao.getAllNotes()
        assertThat(notesInDb).hasSize(3)
        assertThat(notesInDb).containsNoDuplicates()
    }
}