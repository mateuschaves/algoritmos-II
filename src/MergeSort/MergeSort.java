package MergeSort;
import shared.Note;

public class MergeSort {

    public static void main(String[] args) {
        Note[] notes = {
                new Note("Andre", 4),
                new Note("Mariana", 5),
                new Note("Carlos", 8.5),
                new Note("Paulo", 9),
                new Note("Jonas", 3),
                new Note("Juliana", 6.7),
                new Note("Guilherme", 7),
                new Note("Lucia", 9.3),
                new Note("Ana", 10)
        };

        Note[] notesSorted = mergeSort(notes, 0, notes.length);

        for (Note currentNote: notesSorted) {
            System.out.println(currentNote.getStudent() + " - " + currentNote.getValue());
        }
    }

    private static Note[] mergeSort(Note[] notes, int start, int end) {
        int quantity = end - start;
        if (quantity > 1) {
            int middle = (end + start) / 2;
            mergeSort(notes, start, middle);
            mergeSort(notes, middle, end);
            intercalate(notes, start, middle, end);
        }
        return notes;
    }

    private static Note[] intercalate(Note[] notes, int start, int middle, int end) {
        Note[] allNotes = new Note[end - start];

        int currentIndexAllNotes = 0;
        int currentIndexLeft = start;
        int currentIndexRight = middle;

        while(currentIndexLeft < middle && currentIndexRight < end) {

            Note noteLeft = notes[currentIndexLeft];
            Note noteRight = notes[currentIndexRight];

            if (noteLeft.getValue() > noteRight.getValue()) {
                allNotes[currentIndexAllNotes] = noteRight;
                currentIndexRight++;
            } else {
                allNotes[currentIndexAllNotes] = noteLeft;
                currentIndexLeft++;
            }

            currentIndexAllNotes++;
        }

        while(currentIndexLeft < middle) {
            allNotes[currentIndexAllNotes] = notes[currentIndexLeft];
            currentIndexLeft++;
            currentIndexAllNotes++;
        }

        while (currentIndexRight < end) {
            allNotes[currentIndexAllNotes] = notes[currentIndexRight];
            currentIndexRight++;
            currentIndexAllNotes++;
        }

        for (int count = 0; count < currentIndexAllNotes; count++) {
            notes[start + count] = allNotes[count];
        }
        return  notes;
    }
}
