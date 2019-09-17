package merlino.salestaxes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AppTest 
{
    @Test
    public void shouldGreetWorld()
    {
        assertThat(new App().hello("World"), is("Hello World!"));
    }

    @Test
    public void shouldGreetBob()
    {
        assertThat(new App().hello("Bob"), is("Hello Bob!"));
    }
}
