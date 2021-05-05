package note;

public class TestMerge {
    public static void main(String[] args) {
        Note[] notesFromMauricio = { new Note("Andre", 4), new Note("Mariana", 5), new Note("Carlos", 8.5),
                new Note("Paulo", 9), };

        Note[] notesFromRicardo = { new Note("Jonas", 3), new Note("Juliana", 6.7), new Note("Guilherme", 7),
                new Note("Lucia", 9.3), new Note("Ana", 10), };

        Note[] allNotesSorted = merge(notesFromMauricio, notesFromRicardo);

        for (Note currentNote : allNotesSorted) {
            System.out.println(currentNote.getStudent() + " - " + currentNote.getValue());
        }
    }

    private static Note[] merge(Note[] notesFromMauricio, Note[] notesFromRicardo) {
        int finalArrayLength = notesFromMauricio.length + notesFromRicardo.length;
        Note[] allNotes = new Note[finalArrayLength];
        int currentIndexFromMauricio = 0;
        int currentIndexFromRicardo = 0;
        int currentIndexAllNotes = 0;

        while (currentIndexFromMauricio < notesFromMauricio.length && currentIndexFromRicardo < notesFromRicardo.length) {

            Note currentNoteFromMauricio = notesFromMauricio[currentIndexFromMauricio];
            Note currentNoteFromRicardo = notesFromRicardo[currentIndexFromRicardo];

            if (currentNoteFromRicardo.getValue() < currentNoteFromMauricio.getValue()) {
                allNotes[currentIndexAllNotes] = currentNoteFromRicardo;
                currentIndexFromRicardo++;
            } else {
                allNotes[currentIndexAllNotes] = currentNoteFromMauricio;
                currentIndexFromMauricio++;
            }

            currentIndexAllNotes++;
        }

        while (currentIndexFromMauricio < notesFromMauricio.length) {
            allNotes[currentIndexAllNotes] = notesFromMauricio[currentIndexFromMauricio];
            currentIndexAllNotes++;
            currentIndexFromMauricio++;
        }

        while (currentIndexFromRicardo < notesFromRicardo.length) {
            allNotes[currentIndexAllNotes] = notesFromRicardo[currentIndexFromRicardo];
            currentIndexAllNotes++;
            currentIndexFromRicardo++;
        }

        return allNotes;
    }
}
