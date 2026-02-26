package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {
	@Test
    void getNumberOfWords() {
        SpellChecker checker = new SpellChecker();
		int words = checker.getNumberOfWords();
        assertEquals(0, checker.getNumberOfWords());
    }
	@Test
    void addingNewWordIncreasesCountByOne() {
        SpellChecker checker = new SpellChecker();
        checker.addWord("cat");                 
        assertEquals(1, checker.getNumberOfWords());
    }
	@Test
 	void addingDuplicateWordDoesNotChangeCount() {
    	SpellChecker checker = new SpellChecker();
    	checker.addWord("cat");
    	checker.addWord("cat");
    	assertEquals(1, checker.getNumberOfWords());
	}
	 @Test
    void checkAcceptsProperlySpelledWord() {
        SpellChecker checker = new SpellChecker();
        checker.addWord("bank");                
        assertTrue(checker.checkWord("bank"));  
    }

    @Test
    void checkRejectsImproperlySpelledWord() {
        SpellChecker checker = new SpellChecker();
        checker.addWord("bank");                 
        assertFalse(checker.checkWord("bamk"));  
    }

    @Test
    void checkIgnoresCase() {
        SpellChecker checker = new SpellChecker();
        checker.addWord("cat");
        assertTrue(checker.checkWord("CaT"));     
    }

    @Test
    void suggestReturnsAProperWordForMisspelling() {
        SpellChecker checker = new SpellChecker();
        checker.addWord("bank"); 
        assertEquals("bank", checker.suggestWord("bamk")); 
    }

    @Test
    void suggestReturnsOriginalIfAlreadyCorrect() {
        SpellChecker checker = new SpellChecker();
        checker.addWord("bank"); 
        assertEquals("bank", checker.suggestWord("bank")); 
    }
	// removing words tests
	@Test
    void removeWordDecreasesCountAndMakesWordIncorrect() {
        SpellChecker checker = new SpellChecker();
        checker.addWord("cat");
        assertEquals(1, checker.getNumberOfWords());
        checker.removeWord("cat");
        assertEquals(0, checker.getNumberOfWords());
        assertFalse(checker.checkWord("cat"));
    }
	// illegal argument tests
    @Test
    void addWordThrowsOnBlank() {
        SpellChecker checker = new SpellChecker();
        assertThrows(IllegalArgumentException.class, () -> checker.addWord(""));
    }
}
