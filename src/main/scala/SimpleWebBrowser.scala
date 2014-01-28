import java.awt.BorderLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.io.IOException

import javax.swing.JEditorPane
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextField

class SimpleWebBrowser01 {
  val HOMEPAGE = "http://www.google.co.jp/"
  val frame:JFrame = new JFrame
  val webPagePane:JEditorPane = new JEditorPane
  val address:JTextField = new JTextField(HOMEPAGE)

  address.addActionListener(new ActionListener {
    override def actionPerformed(ae:ActionEvent) {
      try {webPagePane.setPage(address.getText)} catch {case e:IOException => }
    }
  })
  webPagePane.setEditable(false)
  try {webPagePane.setPage(HOMEPAGE)} catch { case e:IOException => }
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  frame.add(address, BorderLayout.NORTH)
  frame.add(new JScrollPane(webPagePane))
  frame.setSize(800, 600)
  frame.setVisible(true)
}

object SimpleWebBrowser01 {
  def main(args:Array[String]):Unit = {
    new SimpleWebBrowser01
  }
}
