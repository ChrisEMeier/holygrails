package nfjs

import grails.test.mixin.*
import org.junit.*

@TestFor(Task)
class TaskTests {
    Task t = new Task(name:'name')
    
    @Before
    void setUp() {
        t.quest = new Quest(name:'name')
        mockForConstraintsTests(Task)
    }
    
    void testValid() {
        assert t.validate()
    }
    
    void testBlankName() {
        t.name = ''
        assert !t.validate()
        assert 'blank' == t.errors.name
    }
    
    void testPriorityTooLow() {
        t.priority = Task.MIN_PRIORITY - 1
        assert !t.validate()
        assert 'range' == t.errors.priority
    }
    
    void testPriorityTooHigh() {
        t.priority = Task.MAX_PRIORITY + 1
        assert !t.validate()
        assert 'range' == t.errors.priority
    }
    
    void testPriorityOk() {
        (Task.MIN_PRIORITY..Task.MAX_PRIORITY).each { p ->
            t.priority = p
            assert t.validate()
        }
    }
    
    void testEndDateBeforeStartDate() {
        t.endDate = t.startDate - 1
        assert !t.validate()
        assert 'validator' == t.errors.endDate
    }
}
