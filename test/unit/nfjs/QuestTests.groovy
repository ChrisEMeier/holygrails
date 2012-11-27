package nfjs

import grails.test.mixin.*
import org.junit.*

@TestFor(Quest)
class QuestTests {
    Quest q = new Quest(name:'name')
    
    @Before
    void setUp() {
        mockForConstraintsTests(Quest)
    }
    
    void testValid() {
       assert q.validate()
    }
    
    void testBlankName() {
        q.name = ' '
        assert !q.validate()
        assert 'blank' == q.errors.name
    }
}
