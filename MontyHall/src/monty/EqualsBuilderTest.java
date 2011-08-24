package monty;

import static org.junit.Assert.*;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.junit.Test;


public class EqualsBuilderTest {

	@Test
    public void equalsBuilderUpcastsFromBaseClass() throws Exception {
        InheritedClass c = new InheritedClass("yes");
        InheritedClass d = new InheritedClass("yes");
        assertEquals(d, c);
        InheritedClass e = new InheritedClass("no");
        assertTrue(!d.equals(e));
    }

    private abstract class AbstractBaseClass {

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }

        @Override
        public boolean equals(Object obj) {
            return EqualsBuilder.reflectionEquals(this, obj);
        }

    }

    private class InheritedClass extends AbstractBaseClass {

        private final String a;

        public InheritedClass(String a) {
            this.a = a;
        }
    }
}