package br.com.luxfacta.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import br.com.luxfacta.LuxFacta;

public class LuxFactaTest {
  @Test
  public void testNumbers() {
    LuxFacta n = new LuxFacta(1);
    assertEquals("1",n.say());

    n = new LuxFacta(2);
    assertEquals("2",n.say());

    n = new LuxFacta(28);
    assertEquals("28",n.say());
  }

  @Test
  public void testLux() {
    LuxFacta lux = new LuxFacta(3);
    assertEquals("Lux",lux.say());

    lux = new LuxFacta(40);
    assertFalse(lux.say().equals("Lux"));

    lux = new LuxFacta(42);
    assertEquals("Lux",lux.say());
  }

  @Test
  public void testFacta() {
    LuxFacta facta = new LuxFacta(5);
    assertEquals("Facta",facta.say());

    facta = new LuxFacta(6);
    assertFalse(facta.say().equals("Facta"));

    facta = new LuxFacta(20);
    assertEquals("Facta",facta.say());
  }

  @Test
  public void testLuxFacta() {
    LuxFacta luxFacta = new LuxFacta(15);
    assertEquals("LuxFacta",luxFacta.say());

    luxFacta = new LuxFacta(30);
    assertFalse(luxFacta.say().equals("LuxFacta"));

    luxFacta = new LuxFacta(300);
    assertEquals("LuxFacta",luxFacta.say());
  }
}
