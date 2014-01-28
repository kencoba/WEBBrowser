// sbt compile
// sbt console
// scala> SWTBrowser.main(null) 

import org.eclipse.swt.SWT
import org.eclipse.swt.browser.Browser
import org.eclipse.swt.browser.TitleEvent
import org.eclipse.swt.browser.TitleListener
import org.eclipse.swt.events.KeyAdapter
import org.eclipse.swt.events.KeyEvent
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Text

class SWTBrowser {
  val HOMEPAGE = "http://www.yahoo.co.jp/"
  val display = new Display
  val shell = new Shell(display)
  val urlText = new Text(shell, SWT.SINGLE)
  val browser = new Browser(shell, SWT.FILL)

  urlText.addKeyListener(new KeyAdapter {
    override def keyPressed(e:KeyEvent):Unit = {
      if (e.keyCode == SWT.CR) { browser.setUrl(urlText.getText) }
    }
  })
  browser.addTitleListener(new TitleListener {
    override def changed(event:TitleEvent):Unit = {
      shell.setText(event.title)
    }
  })

  urlText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL))
  browser.setLayoutData(new GridData(GridData.FILL_BOTH))
  shell.setLayout(new GridLayout(1, false))
  shell.setSize(800, 600)

  urlText.setText(HOMEPAGE)
  browser.setUrl(HOMEPAGE)

  shell.open
  while (!shell.isDisposed) {
    if (!display.readAndDispatch) display.sleep
  }
  display.dispose
}

object SWTBrowser {
  def main(args:Array[String]):Unit = {
    new SWTBrowser
  }
}
