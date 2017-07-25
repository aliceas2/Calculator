package calculator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class CalcGUI extends JFrame implements ActionListener {
	
	private JFrame frame;
	private JTextArea text;
	private JButton but[], butAdd, butMinus, butMultiply, butDivide,
    butEquals, butCancel, butSquareRoot, butSquare, butOneDevidedBy,
    butCos, butSin, butTan, butPeriod, butFactorial, butCarrot, butPlot, butRightParen, butLeftParen,
    butArea, butSolve, butX;
	private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9" };
	
	protected Calculator calc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcGUI window = new CalcGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalcGUI() {
		initialize();

		//initialize controller
		calc = new Calculator();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * addActionListeners
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 401, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		but = new JButton[10];
        for (int i = 0; i < 10; i++) {
            but[i] = new JButton(String.valueOf(i));
        }
		
        for (int i = 0; i < 10; i++) {
            panel.add(but[i]);
            but[i].addActionListener(this);
        }
		
		butCos = new JButton("cos");
		butCos.addActionListener(this);
		
		butPeriod = new JButton(".");
		butPeriod.addActionListener(this);
		
		butEquals = new JButton("=");
		butEquals.addActionListener(this);
		
		butSin = new JButton("sin");
		butSin.addActionListener(this);
		
		butTan = new JButton("tan");
		butTan.addActionListener(this);
		
		butFactorial = new JButton("!");
		butFactorial.addActionListener(this);
		
		butCarrot = new JButton("^");
		butCarrot.addActionListener(this);
		
		butAdd = new JButton("+");
		butAdd.addActionListener(this);
		
		butDivide = new JButton("/");
		butDivide.addActionListener(this);
		
		butMultiply = new JButton("*");
		butMultiply.addActionListener(this);
		
		butMinus = new JButton("-");
		butMinus.addActionListener(this);
		
		butPlot = new JButton("Plot");
		butPlot.addActionListener(this);
		
		butRightParen = new JButton(")");
		butRightParen.addActionListener(this);
		
		butLeftParen = new JButton("(");
		butLeftParen.addActionListener(this);
		
		text = new JTextArea();
		text.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		
		butArea = new JButton("Area");
		butArea.addActionListener(this);
		
		butSolve = new JButton("Solve");
		butSolve.addActionListener(this);
		
		butX = new JButton("x");
		butX.addActionListener(this);
		
		/*
		 * Add Groups
		 */
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(butPlot, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(butAdd, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(butMinus, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(but[4], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(but[5], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addComponent(butSolve, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
												.addComponent(butArea, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(butCarrot, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(but[1], Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(butX, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
												.addComponent(but[2], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))
									.addGap(11))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(125)
											.addComponent(but[7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(but[8], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
											.addComponent(butEquals, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(but[0], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
									.addGap(10)))
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(but[9], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addComponent(butPeriod, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(10)
											.addComponent(butFactorial, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
										.addComponent(butTan, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(but[6], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(butCos, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(butMultiply, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(butDivide, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(butLeftParen)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(butRightParen))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(but[3], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(butSin, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(text, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(text, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(butMultiply)
						.addComponent(butMinus)
						.addComponent(butAdd)
						.addComponent(butPlot)
						.addComponent(butDivide))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(butCarrot)
						.addComponent(butRightParen)
						.addComponent(butArea)
						.addComponent(butX)
						.addComponent(butLeftParen))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(but[3])
						.addComponent(butSin)
						.addComponent(but[2])
						.addComponent(but[1])
						.addComponent(butSolve))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(but[4])
						.addComponent(but[5])
						.addComponent(but[6])
						.addComponent(butCos))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(butTan)
						.addComponent(but[9])
						.addComponent(but[8])
						.addComponent(but[7]))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(butFactorial)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(but[0])
								.addComponent(butPeriod)
								.addComponent(butEquals))))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
	

    @Override
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
            writer(calc.calculateMono(Calculator.MonoOperatorModes.COS,
                reader()));
        }

        if (source == butSin) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.SIN,
                reader()));
        }

        if (source == butTan) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.TAN,
                reader()));
        }

        if (source == butEquals) {
            writer(calc.calculateEqual(reader()));
        }

        if (source == butCancel) {
            writer(calc.reset());
        }

        text.selectAll();
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
}
