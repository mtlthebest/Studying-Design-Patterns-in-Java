package my;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import command.Command;
import command.Delete;
import command.Load;
import command.New;
import command.Update;
import entity.Emp;


@SuppressWarnings("serial")
public class Main extends JFrame{
	
	public static void main(String[] args){
		Main main = new Main();
		main.setVisible(true);
	}
	
	LinkedList<Command> commandQueue;
	int commandQueueIndex;
	Emp currentEmp;
	Emp beforeEmp;
	
	JButton saveButton = new JButton("Save");
	JButton newButton = new JButton("New");
	JButton loadButton = new JButton("Load");
	JButton deleteButton = new JButton("Delete");
	JButton undoButton = new JButton("Undo");
	JButton redoButton = new JButton("Redo");
	JTextField numberTextField = new JTextField();
	JTextField enameTextField = new JTextField();
	JTextField jobTextField = new JTextField();
	

	public Main(){
		initButtons();
		commandQueue = new LinkedList<Command>();
		setSize(new Dimension(300, 200));
		setLayout(new GridLayout(6, 2));
		add(new JLabel("No."));
		add(numberTextField);
		add(new JLabel("Name"));
		add(enameTextField);
		add(new JLabel("Job"));
		add(jobTextField);
		add(newButton);
		add(loadButton);
		add(saveButton);
		add(deleteButton);
		add(undoButton);
		add(redoButton);
	}
	
	
	public void update(Emp emp){
		numberTextField.setText(emp.getEmpno().toString());
		enameTextField.setText(emp.getEname());
		jobTextField.setText(emp.getJob());
		beforeEmp = emp; 
	}
	
	public Emp getVals(){
		Emp emp = new Emp();
		emp.setEname(enameTextField.getText());
		emp.setJob(emp.getJob());
		emp.setHiredate(emp.getHiredate());
		return emp;
	}
	
	private void initButtons(){
		loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int num = Integer.parseInt(Main.this.numberTextField.getText());
				System.out.println(num);
				Command cmd = new Load(getVals(), num, Main.this);
				cmd.execute();
				addCommandQueue(cmd);
			}
		});
		
		newButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Emp emp = getVals();
				emp.setHiredate(new Date());
				Command cmd = new New(emp, Main.this);
				cmd.execute();
				addCommandQueue(cmd);
			}
		});
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Emp emp = getVals();
				currentEmp = (Emp) beforeEmp.clone();
				emp.setEmpno(emp.getEmpno());
				emp.setEname(emp.getEname());
				emp.setJob(emp.getJob());
				Command cmd = new Update(beforeEmp, emp, Main.this);
				cmd.execute();
				addCommandQueue(cmd);
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int num = Integer.parseInt(Main.this.numberTextField.getText());
				System.out.println(num);
				Command cmd = new Delete(getVals(), num);
				cmd.execute();
			}
		});
		
		undoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				commandQueue.get(--commandQueueIndex).undo();
			}
		});
		
		redoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				commandQueue.get(commandQueueIndex++).execute();
			}
		});
	}
	
	private void addCommandQueue(Command cmd){
		while(commandQueue.size() != commandQueueIndex){
			commandQueue.removeLast();
		}
		commandQueue.add(cmd);
		commandQueueIndex++;
	}
}