package calculator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import com.fathzer.soft.javaluator.DoubleEvaluator;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class CalcGUI extends JFrame implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	
    private JTextArea text;
    private JButton but[], butAdd, butMinus, butMultiply, butDivide,
    butEquals, butSquareRoot, butSquare, butOneDevidedBy,
    butCos, butSin, butTan, butPeriod, butFactorial, butCarrot, butGraph, butRightParen, butLeftParen,
    butArea, butSolve, butX, butRadian;
    private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9" };
    private Boolean degrees = true;
    protected Calculator calc;
    private Graph graph;

    public CalcGUI() {
    	initComponents();
    	//initialize controller
    	calc = new Calculator();
    }

    /**
     * Initialize the contents of the frame.
	 * addActionListeners
     */                         
    private void initComponents() {
    	
    	but = new JButton[10];
        for (int i = 0; i < 10; i++) {
            but[i] = new JButton(String.valueOf(i));
        }
        
        for (int i = 0; i < 10; i++) {
            but[i].addActionListener(this);
        }

        buttonGroup1 = new ButtonGroup();
        displayPanel = new JPanel();
        blankPanel = new JPanel();
        areaPanels = new JPanel();
        circleRBut = new JRadioButton("Circle");
        rectangleRBut = new JRadioButton("Rectangle");
        triangleRBut = new JRadioButton("Triangle");
        chooseLabel = new JLabel("Choose");
        circlePanel = new JPanel();
        circleLabel = new JLabel("Enter Circle Dimensions");
        radiusLabel = new JLabel("Radius:");
        diameterLabel = new JLabel("Diameter:");
        circumLabel = new JLabel("Circumference:");
        radius = new JTextField();
        diameter = new JTextField();
        circumference = new JTextField();
        circleArea = new JTextField();
        circleAreaLabel = new JLabel("Area:");
        rectanglePanel = new JPanel();
        rectangleLabel = new JLabel("Enter Rectangle Dimensions");
        sideALabel = new JLabel("Side A:");
        sideBLabel = new JLabel("Side B:");
        diagLabel = new JLabel("Diagonal:");
        sideA = new JTextField();
        sideB = new JTextField();
        diagonal = new JTextField();
        rectangleArea = new JTextField();
        rectAreaLabel = new JLabel("Area:");
        perimeter = new JTextField();
        perimeterLabel = new JLabel("Perimeter:");
        trianglePanel = new JPanel();
        triangleLabel = new JLabel("Enter Triangle Dimensions");
        baseLabel = new JLabel("Base:");
        heightLabel = new JLabel("Height:");
        base = new JTextField();
        height = new JTextField();  
        triangleArea = new JTextField();
        triAreaLabel = new JLabel("Area:");
        graphPanel = new JPanel();
        buttonPanel = new JPanel();
        jScrollPane1 = new JScrollPane();
        text = new JTextArea();
        
        beginArea = new JButton("Begin");
        beginArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                beginAreaActionPerformed(evt);
            }
        });
        
        calcCircle = new JButton("Calculate");
        calcCircle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                calcCircleActionPerformed(evt);
            }
        });
        
        calcRectangle = new JButton("Calculate");
        calcRectangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                calcRectangleActionPerformed(evt);
            }
        });
        
        calcTriangle = new JButton("Calculate");
        calcTriangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                calcTriangleActionPerformed(evt);
            }
        });
        
        butGraph = new JButton("Graph");
        butGraph.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butGraphActionPerformed(evt);
            }
        });
        
        butPlot = new JButton("Plot");
        butPlot.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		butPlotActionPerformed(evt);
        	}
        });
        
        butArea = new JButton("Area");
        butArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	butAreaActionPerformed(evt);
            }
        });
        
        butRadian = new JButton("Radians");
        butRadian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butRadianActionPerformed(evt);
            }
        });
        
        butSquareRoot = new JButton("Sqrt");
        butSquareRoot.addActionListener(this);
        
        butClear = new JButton("Clear");
        butClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butClearActionPerformed(evt);
            }
        });
        
        butSolve = new JButton("Solve");
        butSolve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butSolveActionPerformed(evt);
            }
        });
        
        butAdd = new JButton("+");
        butAdd.addActionListener(this);
        
        butCarrot = new JButton("^");
        butCarrot.addActionListener(this);
        
        butEquals = new JButton("=");
        butEquals.addActionListener(this);
        
        butMinus = new JButton("-");
        butMinus.addActionListener(this);
        
        butX = new JButton("X");
        butX.addActionListener(this);
        
        butMultiply = new JButton("*");
        butMultiply.addActionListener(this);
        
        butLeftParen = new JButton("(");
        butLeftParen.addActionListener(this);
        
        butPeriod = new JButton(".");
        butPeriod.addActionListener(this);
        
        butDivide = new JButton("/");
        butDivide.addActionListener(this);
        
        butRightParen = new JButton(")");
        butRightParen.addActionListener(this);
        
        butSin = new JButton("Sin");
        butSin.addActionListener(this);
        
        butCos = new JButton("Cos");
        butCos.addActionListener(this);
        
        butTan = new JButton("Tan");
        butTan.addActionListener(this);
        
        butFactorial = new JButton("!");
        butFactorial.addActionListener(this);
        
        exitBut1 = new JButton("Exit");
        exitBut1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butExitActionPerformed(evt);
            }
        });
        
        exitBut2 = new JButton("Exit");
        exitBut2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butExitActionPerformed(evt);
            }
        });
        
        exitBut3 = new JButton("Exit");
        exitBut3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butExitActionPerformed(evt);
            }
        });
        
        exitBut4 = new JButton("Exit");
        exitBut4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butExitActionPerformed(evt);
            }
        });
        
        exitBut5 = new JButton("Exit");
        exitBut5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                butExitActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        displayPanel.setLayout(new CardLayout());
        GroupLayout blankPanelLayout = new GroupLayout(blankPanel);
        blankPanel.setLayout(blankPanelLayout);
        //Begin layout definitions
        blankPanelLayout.setHorizontalGroup(
            blankPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );
        blankPanelLayout.setVerticalGroup(
            blankPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        displayPanel.add(blankPanel, "blankPanel");
        blankPanel.getAccessibleContext().setAccessibleName("");
        circleRBut.setSelected(true);
        buttonGroup1.add(circleRBut);
        buttonGroup1.add(rectangleRBut);
        buttonGroup1.add(triangleRBut);
        chooseLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout areaPanelsLayout = new GroupLayout(areaPanels);
        areaPanels.setLayout(areaPanelsLayout);
        areaPanelsLayout.setHorizontalGroup(
            areaPanelsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(areaPanelsLayout.createSequentialGroup()
                .addGroup(areaPanelsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(areaPanelsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(areaPanelsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(circleRBut)
                            .addComponent(rectangleRBut)
                            .addComponent(triangleRBut)))
                    .addGroup(areaPanelsLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(chooseLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                    .addGroup(areaPanelsLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(beginArea)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitBut1)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        areaPanelsLayout.setVerticalGroup(
                areaPanelsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(areaPanelsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(chooseLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                    .addComponent(circleRBut)
                    .addGap(18, 18, 18)
                    .addComponent(rectangleRBut)
                    .addGap(18, 18, 18)
                    .addComponent(triangleRBut)
                    .addGap(46, 46, 46)
                    .addGroup(areaPanelsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(beginArea)
                        .addComponent(exitBut1))
                    .addContainerGap())
            );

        displayPanel.add(areaPanels, "areaPanels");
        circleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        circleAreaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout circlePanelLayout = new GroupLayout(circlePanel);
        circlePanel.setLayout(circlePanelLayout);
        circlePanelLayout.setHorizontalGroup(
            circlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(circlePanelLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(circleLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(circlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(circlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(radiusLabel)
                    .addComponent(diameterLabel)
                    .addComponent(circumLabel))
                .addGap(27, 27, 27)
                .addGroup(circlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(diameter, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(circumference)
                    .addComponent(radius))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(circlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, circlePanelLayout.createSequentialGroup()
                        .addComponent(circleArea, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(GroupLayout.Alignment.TRAILING, circlePanelLayout.createSequentialGroup()
                        .addComponent(circleAreaLabel)
                        .addGap(68, 68, 68))))
            .addGroup(circlePanelLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(calcCircle)
                .addGap(18, 18, 18)
                .addComponent(exitBut2)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        circlePanelLayout.setVerticalGroup(
            circlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(circlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(circleLabel)
                .addGap(12, 12, 12)
                .addGroup(circlePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(radius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(radiusLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(circlePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(diameter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(diameterLabel)
                    .addComponent(circleArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(circlePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(circumference, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(circumLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(circlePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(calcCircle)
                    .addComponent(exitBut2))
                .addContainerGap())
            .addGroup(circlePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(circleAreaLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        displayPanel.add(circlePanel, "circlePanel");
        rectangleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rectAreaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout rectanglePanelLayout = new GroupLayout(rectanglePanel);
        rectanglePanel.setLayout(rectanglePanelLayout);
        rectanglePanelLayout.setHorizontalGroup(
            rectanglePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rectanglePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rectanglePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sideALabel)
                    .addComponent(sideBLabel)
                    .addComponent(diagLabel)
                    .addComponent(perimeterLabel))
                .addGap(27, 27, 27)
                .addGroup(rectanglePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(sideB, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(diagonal)
                    .addComponent(sideA)
                    .addComponent(perimeter))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(rectanglePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, rectanglePanelLayout.createSequentialGroup()
                        .addComponent(rectangleArea, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(GroupLayout.Alignment.TRAILING, rectanglePanelLayout.createSequentialGroup()
                        .addComponent(rectAreaLabel)
                        .addGap(68, 68, 68))))
            .addGroup(rectanglePanelLayout.createSequentialGroup()
                .addGroup(rectanglePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(rectanglePanelLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(rectangleLabel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
                    .addGroup(rectanglePanelLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(calcRectangle)
                        .addGap(18, 18, 18)
                        .addComponent(exitBut3)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rectanglePanelLayout.setVerticalGroup(
            rectanglePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rectanglePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rectangleLabel)
                .addGap(12, 12, 12)
                .addGroup(rectanglePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sideA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sideALabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rectanglePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sideB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sideBLabel)
                    .addComponent(rectangleArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(rectanglePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(diagonal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(diagLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(rectanglePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(perimeter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(perimeterLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rectanglePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(calcRectangle)
                    .addComponent(exitBut3))
                .addContainerGap())
            .addGroup(rectanglePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(rectAreaLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        displayPanel.add(rectanglePanel, "rectanglePanel");
        triangleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        triAreaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout trianglePanelLayout = new GroupLayout(trianglePanel);
        trianglePanel.setLayout(trianglePanelLayout);
        trianglePanelLayout.setHorizontalGroup(
            trianglePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(trianglePanelLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(triangleLabel, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(trianglePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(trianglePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(baseLabel)
                    .addComponent(heightLabel))
                .addGap(76, 76, 76)
                .addGroup(trianglePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(height, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(base))
                .addGap(18, 78, Short.MAX_VALUE)
                .addGroup(trianglePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, trianglePanelLayout.createSequentialGroup()
                        .addComponent(triangleArea, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(GroupLayout.Alignment.TRAILING, trianglePanelLayout.createSequentialGroup()
                        .addComponent(triAreaLabel)
                        .addGap(68, 68, 68))))
            .addGroup(trianglePanelLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(calcTriangle)
                .addGap(18, 18, 18)
                .addComponent(exitBut4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        trianglePanelLayout.setVerticalGroup(
            trianglePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(trianglePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(triangleLabel)
                .addGap(12, 12, 12)
                .addGroup(trianglePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(base, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(baseLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(trianglePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(height, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(heightLabel)
                    .addComponent(triangleArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(trianglePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(calcTriangle)
                    .addComponent(exitBut4))
                .addContainerGap())
            .addGroup(trianglePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(triAreaLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        displayPanel.add(trianglePanel, "trianglePanel");
        
        JPanel graphButs = new JPanel();
        graphButs.add(butPlot);
        graphButs.add(exitBut5);
        graphPanel.setLayout(new BorderLayout());
        graphPanel.setSize(445, 263);
        graphPanel.add(graphButs, BorderLayout.PAGE_END);
        
        displayPanel.add(graphPanel, "graphPanel");

        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        butRadian.setPreferredSize(new Dimension(75, 29));
        butClear.setPreferredSize(new Dimension(75, 29));
        butSolve.setPreferredSize(new Dimension(75, 29));
        butAdd.setPreferredSize(new Dimension(50, 29));
        butCarrot.setPreferredSize(new Dimension(50, 29));
        but[1].setPreferredSize(new Dimension(50, 29));
        but[4].setPreferredSize(new Dimension(50, 29));
        but[7].setPreferredSize(new Dimension(50, 29));
        butEquals.setPreferredSize(new Dimension(50, 29));   
        
        GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(butArea, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(butRadian, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butSquareRoot, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butClear, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butSolve, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butGraph, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(butAdd, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(butCarrot, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(but[1], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(but[7], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(but[4], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(butEquals, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(but[5], GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(but[2], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(butX, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(butMinus, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(but[8], GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(but[0], GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(butLeftParen, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(but[3], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(but[6], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(but[9], GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(butPeriod, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(butMultiply, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(butTan, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butCos, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butSin, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butRightParen, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butFactorial, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butDivide, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(butGraph, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butAdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(butMinus)
                    .addComponent(butMultiply)
                    .addComponent(butDivide))
                .addGap(18, 18, 18)
                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(butArea)
                    .addComponent(butCarrot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(butX)
                    .addComponent(butLeftParen)
                    .addComponent(butRightParen))
                .addGap(18, 18, 18)
                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(butRadian, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(but[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(but[2])
                    .addComponent(but[3])
                    .addComponent(butSin))
                .addGap(18, 18, 18)
                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(butSquareRoot)
                    .addComponent(but[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(but[5])
                    .addComponent(but[6])
                    .addComponent(butCos))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(butClear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(but[7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(but[8])
                    .addComponent(but[9])
                    .addComponent(butTan))
                .addGap(18, 18, 18)
                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(butSolve, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(butEquals, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(but[0])
                    .addComponent(butPeriod)
                    .addComponent(butFactorial))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(displayPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void beginAreaActionPerformed(ActionEvent evt) {                                          
        if (circleRBut.isSelected()) {
            CardLayout card = (CardLayout)displayPanel.getLayout();
            card.show(displayPanel, "circlePanel");
        } else if (rectangleRBut.isSelected()) {
            CardLayout card = (CardLayout)displayPanel.getLayout();
            card.show(displayPanel, "rectanglePanel");
        } else if (triangleRBut.isSelected()) {
            CardLayout card = (CardLayout)displayPanel.getLayout();
            card.show(displayPanel, "trianglePanel");
        }
    }                                         

    private void calcTriangleActionPerformed(ActionEvent evt) {                                             
    	DecimalFormat df = new DecimalFormat("0.0000");
    	Area area = new Area(trianglePanel);
    	Double[] data = new Double[4];
    	String str;
    	
    	for(int i = 0; i < 4; i++) {
    		data[i] = null;
    	}
        
        str = base.getText();
        if(!str.isEmpty()) {
        	try {
        		data[0] = Double.valueOf(str);
        	} catch(NumberFormatException ex) {
        		JOptionPane.showMessageDialog(trianglePanel, "Base: \n Please Enter Positive Numbers ONLY");
        	}
        }       	
        if(data[0] == null || data[0] < 0) {
        	data[0] = 0.0;
        }
        
        str = height.getText();
        if(!str.isEmpty()) {
        	try {
        		data[1] = Double.valueOf(str);
        	} catch(NumberFormatException ex) {
        		JOptionPane.showMessageDialog(trianglePanel, "Height: \n Please Enter Positive Numbers ONLY");
        	}
        }
        if(data[1] == null || data[1] < 0) {
        	data[1] = 0.0;
        }
        
        data = area.calculateTriangle(data);
        base.setText(df.format(Double.valueOf(data[0])));
        height.setText(df.format(Double.valueOf(data[1])));
    }

    private void calcRectangleActionPerformed(ActionEvent evt) {                                              
    	DecimalFormat df = new DecimalFormat("0.0000");
    	Area area = new Area(rectanglePanel);
    	Double[] data = new Double[5];
    	String str;
    	
    	for(int i = 0; i < 5; i++) {
    		data[i] = null;
    	}
        
        str = sideA.getText();
        if(!str.isEmpty()) {
        	try {
        		data[0] = Double.valueOf(str);
        	} catch(NumberFormatException ex) {
        		JOptionPane.showMessageDialog(rectanglePanel, "Side A: \n Please Enter Positive Numbers ONLY");
        	}
        }       	
        if(data[0] == null || data[0] < 0) {
        	data[0] = 0.0;
        }
        
        str = sideB.getText();
        if(!str.isEmpty()) {
        	try {
        		data[1] = Double.valueOf(str);
        	} catch(NumberFormatException ex) {
        		JOptionPane.showMessageDialog(rectanglePanel, "Side B: \n Please Enter Positive Numbers ONLY");
        	}
        }
        if(data[1] == null || data[1] < 0) {
        	data[1] = 0.0;
        }
        
        str = diagonal.getText();
        if(!str.isEmpty()) {
        	try {
        		data[2] = Double.valueOf(str);
        	} catch(NumberFormatException ex) {
        		JOptionPane.showMessageDialog(rectanglePanel, "Diagonal: \n Please Enter Positive Numbers ONLY"); ;
        	}
        }
        if(data[2] == null || data[2] < 0) {
        	data[2] = 0.0;
        }
        
        str = perimeter.getText();
        if(!str.isEmpty()) {
        	try {
        		data[3] = Double.valueOf(str);
        	} catch(NumberFormatException ex) {
        		JOptionPane.showMessageDialog(rectanglePanel, "Perimeter: \n Please Enter Positive Numbers ONLY");
        	}
        }
        if(data[3] == null || data[3] < 0) {
        	data[3] = 0.0;
        }
        
        str = rectangleArea.getText();
        if(!str.isEmpty()) {
        	try {
        		data[4] = Double.valueOf(str);
        	} catch(NumberFormatException ex) {
        		JOptionPane.showMessageDialog(rectanglePanel, "Area: \n Please Enter Positive Numbers ONLY");
        	}
        }
        if(data[4] == null || data[4] < 0) {
        	data[4] = 0.0;
        }
        
        data = area.calculateRectangle(data);
        sideA.setText(df.format(Double.valueOf(data[0])));
        sideB.setText(df.format(Double.valueOf(data[1])));
        diagonal.setText(df.format(Double.valueOf(data[2])));
        perimeter.setText(df.format(Double.valueOf(data[3])));
        rectangleArea.setText(df.format(Double.valueOf(data[4])));
    }                                             

    private void calcCircleActionPerformed(ActionEvent evt) { 
    	DecimalFormat df = new DecimalFormat("0.0000");
    	Area area = new Area(circlePanel);
    	Double[] data = new Double[4];
    	String str;
    	
    	for(int i = 0; i < 4; i++) {
    		data[i] = null;
    	}
        
        str = radius.getText();
        if(!str.isEmpty()) {
        	try {
        		data[0] = Double.valueOf(str);
        	} catch(NumberFormatException ex) {
        		JOptionPane.showMessageDialog(circlePanel, "Radius: \n Please Enter Positive Numbers ONLY");
        	}
        }       	
        if(data[0] == null || data[0] < 0) {
        	data[0] = 0.0;
        }
        
        str = diameter.getText();
        if(!str.isEmpty()) {
        	try {
        		data[1] = Double.valueOf(str);
        	} catch(NumberFormatException ex) {
        		JOptionPane.showMessageDialog(circlePanel, "Diameter: \n Please Enter Positive Numbers ONLY");
        	}
        }
        if(data[1] == null || data[1] < 0) {
        	data[1] = 0.0;
        }
        
        str = circumference.getText();
        if(!str.isEmpty()) {
        	try {
        		data[2] = Double.valueOf(str);
        	} catch(NumberFormatException ex) {
        		JOptionPane.showMessageDialog(circlePanel, "Circumference: \n Please Enter Positive Numbers ONLY"); ;
        	}
        }
        if(data[2] == null || data[2] < 0) {
        	data[2] = 0.0;
        }
        
        str = circleArea.getText();
        if(!str.isEmpty()) {
        	try {
        		data[3] = Double.valueOf(str);
        	} catch(NumberFormatException ex) {
        		JOptionPane.showMessageDialog(circlePanel, "Area: \n Please Enter Positive Numbers ONLY");
        	}
        }
        if(data[3] == null || data[3] < 0) {
        	data[3] = 0.0;
        }
        
        data = area.calculateCircle(data);
        radius.setText(df.format(Double.valueOf(data[0])));
        diameter.setText(df.format(Double.valueOf(data[1])));
        circumference.setText(df.format(Double.valueOf(data[2])));
        circleArea.setText(df.format(Double.valueOf(data[3])));
    }                                          

    public void actionPerformed(ActionEvent e) {
    	final Object source = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (source == but[i]) {
                text.replaceSelection(buttonValue[i]);
                return;
            }
        }

		if (source == butAdd) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.ADD, reader()));
        }

        if (source == butMinus) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.MINUS, reader()));
        }

        if (source == butMultiply) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.MULTIPLY,
                reader()));
        }

        if (source == butDivide) {
            writer(calc
                .calculateBi(Calculator.BiOperatorModes.DIVIDE, reader()));
        }
        
        if (source == butCarrot) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.POWER, reader()));
        }

        if (source == butSquare) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.SQUARE,
                reader()));
        }

        if (source == butSquareRoot) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.SQUAREROOT,
                reader()));
        }

        if (source == butOneDevidedBy) {
            writer(calc.calculateMono(
                    Calculator.MonoOperatorModes.ONEDIVIDEDBY, reader()));
        }

        if (source == butCos) {
        	if (degrees) {
        		writer(calc.calculateMono(Calculator.MonoOperatorModes.COS, Math.toRadians(reader())));
        	} else {
        		writer(calc.calculateMono(Calculator.MonoOperatorModes.COS, reader()));
        	}
        }

        if (source == butSin) {
        	if (degrees) {
        		writer(calc.calculateMono(Calculator.MonoOperatorModes.SIN, Math.toRadians(reader())));
        	} else {
        		writer(calc.calculateMono(Calculator.MonoOperatorModes.SIN, reader()));
        	}
        }

        if (source == butTan) {
        	if (degrees) {
        		writer(calc.calculateMono(Calculator.MonoOperatorModes.TAN, Math.toRadians(reader())));
        	} else {
        		writer(calc.calculateMono(Calculator.MonoOperatorModes.TAN, reader()));
        	}
        }

        if (source == butFactorial) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.FACT,
                reader()));
        }
        
        if (source == butEquals) {
            writer(calc.calculateEqual(reader()));
        }
        
        text.selectAll();
    }                                   

    private void butGraphActionPerformed(ActionEvent evt) {
    	graph = new Graph();
        graphPanel.add(graph);
    	CardLayout card = (CardLayout)displayPanel.getLayout();
        card.show(displayPanel, "graphPanel");
    }    
    
    private void butPlotActionPerformed(ActionEvent evt) {
    	String expression = text.getText();
        Double result = new DoubleEvaluator().evaluate(expression);//Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
    	writer(result);
    }

    private void butAreaActionPerformed(ActionEvent evt) {
    	CardLayout card = (CardLayout)displayPanel.getLayout();
        card.show(displayPanel, "areaPanels");
    }
    
    private void butRadianActionPerformed(ActionEvent evt) {                                          
        if (degrees) {
            degrees = false;
            butRadian.setText("Degrees");
        } else {
            degrees = true;
            butRadian.setText("Radians");
        }
    }                                                                             

    private void butSolveActionPerformed(ActionEvent evt) {                                         
        writer(calc.calculateEqual(reader()));
    }  
    
    private void butClearActionPerformed(ActionEvent evt) {                                         
        writer(calc.reset());
        radius.setText("");
        diameter.setText("");
        circumference.setText("");
        circleArea.setText("");
        rectangleArea.setText("");
        triangleArea.setText("");
        sideA.setText("");
        sideB.setText("");
        diagonal.setText("");
        perimeter.setText("");
        base.setText("");
        height.setText("");
    }    
    
    private void butExitActionPerformed(ActionEvent evt) {
    	CardLayout card = (CardLayout)displayPanel.getLayout();
        card.show(displayPanel, "blankPanel");
        text.setText("");
    }

    public Double reader() {
        Double num;
        String str;
        str = text.getText();
        num = Double.valueOf(str);

        return num;
    }

    public void writer(final Double num) {
        if (Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }
    
    
    public static void main(String args[]) {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalcGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalcGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalcGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalcGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalcGUI().setVisible(true);
            }
        });
    }

    // Variables declaration                     
    private JPanel areaPanels;
    private JTextField base;
    private JLabel baseLabel;
    private JButton beginArea;
    private JPanel blankPanel;
    private JButton butClear;
    private ButtonGroup buttonGroup1;
    private JPanel buttonPanel;
    private JButton calcCircle;
    private JButton calcRectangle;
    private JButton calcTriangle;
    private JLabel chooseLabel;
    private JTextField circleArea;
    private JLabel circleAreaLabel;
    private JLabel circleLabel;
    private JPanel circlePanel;
    private JRadioButton circleRBut;
    private JLabel circumLabel;
    private JTextField circumference;
    private JLabel diagLabel;
    private JTextField diagonal;
    private JTextField diameter;
    private JLabel diameterLabel;
    private JPanel displayPanel;
    private JPanel graphPanel;
    private JTextField height;
    private JLabel heightLabel;
    private JScrollPane jScrollPane1;
    private JTextField perimeter;
    private JLabel perimeterLabel;
    private JTextField radius;
    private JLabel radiusLabel;
    private JLabel rectAreaLabel;
    private JTextField rectangleArea;
    private JLabel rectangleLabel;
    private JPanel rectanglePanel;
    private JRadioButton rectangleRBut;
    private JTextField sideA;
    private JLabel sideALabel;
    private JTextField sideB;
    private JLabel sideBLabel;
    private JLabel triAreaLabel;
    private JTextField triangleArea;
    private JLabel triangleLabel;
    private JPanel trianglePanel;
    private JRadioButton triangleRBut;
    private JButton butPlot;
    private JButton exitBut1;
    private JButton exitBut2;
    private JButton exitBut3;
    private JButton exitBut4;
    private JButton exitBut5;
    
    // End of variables declaration                   
}
