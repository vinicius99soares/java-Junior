package br.com.luxfacta.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import br.com.luxfacta.Path;
import br.com.luxfacta.exception.InvalidPathException;

public class PathTest {
  @Test
  public void testChangeCurrentPath() throws InvalidPathException {
    Path path = new Path("/a/b/c/d");
    path.cd("../x");
    assertEquals("/a/b/c/x",path.getCurrentPath());
  }

  @Test
  public void testTwoTimesDown() throws InvalidPathException {
    Path path = new Path("/a/b/c/d");
    path.cd("../../x");
    assertEquals("/a/b/x",path.getCurrentPath());
  }

  @Test
  public void testMiddleParentDir() throws InvalidPathException {
    Path path = new Path("/a/b/c/d");
    path.cd("a/../x");
    assertEquals("/a/b/c/d/x",path.getCurrentPath());
  }

  @Test
  public void testThreeTimesUp() throws InvalidPathException {
    Path path = new Path("/a/b/c");
    path.cd("d/e/f");
    assertEquals("/a/b/c/d/e/f",path.getCurrentPath());
  }

  @Test
  public void testDoubleSlash() throws InvalidPathException {
    Path path = new Path("/a/b/c");
    path.cd("d//e/f");
    assertEquals("/a/b/c/d/e/f",path.getCurrentPath());
  }

  @Test
  public void testRootPath() throws InvalidPathException {
    Path path = new Path("/a/b/c");
    path.cd("/d/e/f");
    assertEquals("/d/e/f",path.getCurrentPath());
  }

  @Test
  public void testChangeToRootPath() throws InvalidPathException {
    Path path = new Path("/a/b/c");
    path.cd("/");
    assertEquals("/",path.getCurrentPath());
  }

  @Test(expected = InvalidPathException.class)
  public void testInvalidPath() throws InvalidPathException {
    Path path = new Path("/a/b/c");
    path.cd("/?");
  }

  @Test(expected = InvalidPathException.class)
  public void testSingleDot() throws InvalidPathException {
    Path path = new Path("/a/b/c");
    path.cd("./d");
  }

  @Test(expected = InvalidPathException.class)
  public void testTripleDot() throws InvalidPathException {
    Path path = new Path("/a/b/c");
    path.cd(".../d");
  }

  @Test(expected = InvalidPathException.class)
  public void testFourDots() throws InvalidPathException {
    Path path = new Path("/a/b/c");
    path.cd("..../d");
  }

  @Test
  public void testParentFromRoot() throws InvalidPathException {
    Path path = new Path("/");
    path.cd("..");
    assertEquals("/",path.getCurrentPath());
  }
}
