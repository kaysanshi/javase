package com.mhl.tools;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.media.bean.playerbean.*;
import java.io.IOException;
import javax.swing.JOptionPane;

import javafx.scene.media.MediaPlayer;

import java.awt.*;



public class lyt extends JFrame implements Runnable {
public MediaPlayer soumd1;
  private JButton playSound, stopsound, tjian,loopSound;
private JMenuItem jmiOpen,jmiSave,jmiExit,jmiAbout;
  public JPanel jp1, jp2, jp3, jp4;
public JList jl;
  private JButton last, next, stop;
public Vector vector, mingcheng;
boolean fo = false, geshi = false;
JLabel jl1, jl2, sj1, sj2;
JTextField jt1, jt2;
int a = 0, b = 0, you = 1, mm = 0;
 public lyt() {
    super("200842018java音乐播放器");
    soumd1 = new MediaPlayer();
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    mingcheng = new Vector();
    jp1 = new JPanel();
    c.add(jp1);

JMenuBar mb=new JMenuBar();
    setJMenuBar(mb);
JMenu fileMenu=new JMenu("文件");
    mb.add(fileMenu);
    JMenu helpMenu=new JMenu("帮助");
    mb.add(helpMenu);
 fileMenu.add(jmiOpen=new JMenuItem("打开"));
    fileMenu.add(jmiSave=new JMenuItem("播放"));
helpMenu.add(jmiAbout=new JMenuItem("关于"));

    JPanel jp2 = new JPanel();
    jp2.setLayout(new FlowLayout());
    jp2.add(last = new JButton("后退"));
    jp2.add(playSound = new JButton("播放"));
    jp2.add(tjian = new JButton("添加"));
    jp2.add(next = new JButton("前进"));
    jp2.add(stopsound = new JButton("停止"));
     jp2.add(loopSound= new JButton("循环"));
    getContentPane().add(jp2, BorderLayout.SOUTH);

    jp2 = new JPanel();
    jp2.add(playSound);
    jp2.add(stopsound);
    c.add(jp2);
    jp4 = new JPanel();
    sj1 = new JLabel();
    sj2 = new JLabel();
    jp4.add(sj1);
    jp4.add(sj2);
    c.add(jp4);

    vector = new Vector();
    jl = new JList(mingcheng);
    jl.setVisibleRowCount(4);
    jl.setFixedCellHeight(30);
    jl.setFixedCellWidth(265);

jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
;
    c.add(new JScrollPane(jl));

    jp3 = new JPanel();
    jp3.add(tjian);

    c.add(jp3);

    try {
      String s = "d:\\music.txt";
      ObjectInputStream input = new ObjectInputStream(
          new FileInputStream(s));
      lujin a1 = (lujin) input.readObject();
      mingcheng = a1.b;
      vector = a1.a;
      jl.setListData(mingcheng);
    }
    catch (Exception e) {
      System.out.println("D盘没有保存音乐文件");

    }
    jmiOpen.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent event) {
         JFileChooser fileChooser = new JFileChooser();
         fileChooser

.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES
);
         fileChooser.setCurrentDirectory(new File("."));
         fileChooser
             .setFileFilter(new
javax.swing.filechooser.FileFilter() {
           public boolean accept(File file) {
             String name = file.getName().toLowerCase();
             return name.endsWith(".mp3")
                 || file.isDirectory();
           }

           public String getDescription() {
             return "音乐文件(*.mp3)";
           }
         });
         if (fileChooser.showOpenDialog(lyt.this) ==
JFileChooser.APPROVE_OPTION) {
           String fileName =
fileChooser.getSelectedFile()
               .getAbsolutePath();
           vector.add(fileName);
           StringBuffer buffer = daoxu(fileName);
           mingcheng.add(buffer);
         }
       }
     });

    tjian.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          JFileChooser fileChooser = new JFileChooser();
          fileChooser

.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES
);
          fileChooser.setCurrentDirectory(new
File("."));
          fileChooser
              .setFileFilter(new
javax.swing.filechooser.FileFilter() {
            public boolean accept(File file) {
              String name =
file.getName().toLowerCase();
              return name.endsWith(".mp3")
                  || file.isDirectory();
            }

            public String getDescription() {
              return "音乐文件(*.mp3)";
            }
          });
          if (fileChooser.showOpenDialog(lyt.this) ==
JFileChooser.APPROVE_OPTION) {
            String fileName =
fileChooser.getSelectedFile()
                .getAbsolutePath();
            vector.add(fileName);
            StringBuffer buffer = daoxu(fileName);
            mingcheng.add(buffer);
          }
        }
      });
     jmiSave.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
             if (jl.getSelectedIndex() >= 0) {
               String yy = (String)
vector.get(jl.getSelectedIndex());
               File ff = new File(yy);
               if (ff.exists()) {
                 if (yy.matches("[\\S\\s]*.mp3") ||
yy.matches("[\\S\\s]*.mp3")) {
                   if (soumd1 != null) {
                     a = 0;
                     b = 0;
                     you = 0;
                     soumd1.stop();
                   }
                   soumd1.setMediaLocation("file:/" +
yy);
                   fo = true;
                   soumd1.start();
                   geshi = true;
                   try {
                     Thread.sleep(500);
                   }
                   catch (InterruptedException eee) {
                   }

                 }
                 else
                   JOptionPane.showMessageDialog(null,
                                                 "无法播放");
               }
               else
                 JOptionPane.showMessageDialog(null,
                                               "此歌曲已经存在");
             }
             else
               JOptionPane.showMessageDialog(null, "请选择音乐文件");
           }
         });
         loopSound.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             if (jl.getSelectedIndex() >= 0) {
              String yy = (String) vector.get(jl.getSelectedIndex());
              File ff = new File(yy);
              if (ff.exists()) {
               if (yy.matches("[\\S\\s]*.mp3")|| yy.matches("[\\S\\s]*.MP3")) {
                if (soumd1 != null) {
                 a = 0;
                 b = 0;
                 you = 0;
                 soumd1.stop();
                }
                   soumd1.setMediaLocation("file:/" + yy);
                fo = true;
                soumd1.start();
                geshi=true;
                try {
                 Thread.sleep(500);
                } catch (InterruptedException we) {
                }



               } else
                JOptionPane.showMessageDialog(null,
                  "不支持此格式，无法播放");
              } else
               JOptionPane.showMessageDialog(null,
                 "此歌曲文件已经存在");

             }
             else
              JOptionPane.showMessageDialog(null, "请选择音乐文件");
            }
           });



    playSound.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (jl.getSelectedIndex() >= 0) {
          String yy = (String)
vector.get(jl.getSelectedIndex());
          File ff = new File(yy);
          if (ff.exists()) {
            if (yy.matches("[\\S\\s]*.mp3") ||
yy.matches("[\\S\\s]*.mp3")) {
              if (soumd1 != null) {
                a = 0;
                b = 0;
                you = 0;
                soumd1.stop();
              }
              soumd1.setMediaLocation("file:/" + yy);
              fo = true;
              soumd1.start();
              geshi = true;
              try {
                Thread.sleep(500);
              }
              catch (InterruptedException eee) {
              }

            }
            else
              JOptionPane.showMessageDialog(null,
                                            "无法播放");
          }
          else
            JOptionPane.showMessageDialog(null,
                                          "此歌曲已经存在");
        }
        else
          JOptionPane.showMessageDialog(null, "请选择音乐文件");
      }
    });

    stopsound.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        a = 0;
        b = 0;
        you = 0;
        mm = 0;
        geshi = false;
        fo = false;

        sj1.setText(null);
        sj2.setText(null);
        if (jl.getSelectedIndex() >= 0)
          soumd1.stop();

      }
    });

    jl.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent event) {
        if (event.getClickCount() == 2) {
          if (jl.getSelectedIndex() >= 0) {
            String yy = (String)
vector.get(jl.getSelectedIndex());
            File ff = new File(yy);
            if (ff.exists()) {
              if (yy.matches("[\\S\\s]*.mp3") ||
yy.matches("[\\S\\s]*.mp3")) {
                if (soumd1 != null) {
                  a = 0;
                  b = 0;
                  you = 0;
                  soumd1.stop();
                }
                soumd1.setMediaLocation("file:/" + yy);
                fo = true;
                soumd1.start();
                geshi = true;
                try {
                  Thread.sleep(500);
                }
                catch (InterruptedException e) {
                }

              }
              else
         JOptionPane.showMessageDialog(null,
                                            "无法播放");
            }
            else
              JOptionPane.showMessageDialog(null,
                                            "此歌曲已经存在");

          }
        }
        if (event.isMetaDown()) {
          if (jl.getSelectedIndex() >= 0) {
            int a = jl.getSelectedIndex();

jt1.setText(mingcheng.get(jl.getSelectedIndex()) + "");

jt2.setText(vector.get(jl.getSelectedIndex()) + "");
          }
        }
      }
    });
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        String s = "d:\\music.txt";
        mmm(vector, mingcheng, s);
        System.exit(0);
      }
    });
    setSize(370, 270);
    setVisible(true);
  }
  public void run() {
    while (true) {
      Date now = new Date();

      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException e) {
      }
      if (geshi) {
        you = (int) soumd1.getMediaTime().getSeconds();
        mm = you % 60;
        if (you != 0)
          if (you % 60 == 0) {
            b++;
          }
        sj1.setText(b + ":" + mm);

      }
    }
  }
  public StringBuffer daoxu(String fileName) {
    String mc = "";
    for (int i = fileName.length(); i >= 1; i--) {
      if (fileName.charAt(i - 1) == '\\')
        break;
      mc += fileName.charAt(i - 1);
    }
    StringBuffer buffer = new StringBuffer(mc);
    StringBuffer mm = buffer.reverse();
    return mm;
  }
  public void mmm(Vector vector, Vector mingcheng,
String lujin) {
    lujin a = new lujin(vector, mingcheng);
    try {
      ObjectOutputStream output = new
ObjectOutputStream(new FileOutputStream(
          lujin));
      output.writeObject(a);
      output.flush();
      output.close();
    }
    catch (Exception e) {

    }
  }
  public static void main(String agrs[]) {
  lyt s = new lyt();
    Thread t1 = new Thread(s);
    t1.start();
    s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }


  class lujin
      implements Serializable {

    Vector a = new Vector();

    Vector b = new Vector();

    public lujin(Vector vector, Vector mingcheng) {
      a = vector;
      b = mingcheng;
    }

  }
}

