import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * 複製可能なJLabel
 * @author shintaro
 *
 */
public class ClonableJLabel extends JLabel implements Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClonableJLabel() {
		super();
	}

	public ClonableJLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
	}

	public ClonableJLabel(Icon image) {
		super(image);
	}

	public ClonableJLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
	}

	public ClonableJLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
	}

	public ClonableJLabel(String text) {
		super(text);
	}

	@Override
	public ClonableJLabel clone(){
		ClonableJLabel clone = new ClonableJLabel();
		clone.setActionMap(this.getActionMap());
		clone.setAlignmentX(this.getAlignmentX());
		clone.setAlignmentY(this.getAlignmentY());
		clone.setAutoscrolls(this.getAutoscrolls());
		clone.setBackground(this.getBackground());
		clone.setBorder(this.getBorder());
		clone.setBounds(this.getBounds());
		clone.setComponentOrientation(this.getComponentOrientation());
		clone.setComponentPopupMenu(this.getComponentPopupMenu());
		clone.setCursor(this.getCursor());
		clone.setDebugGraphicsOptions(this.getDebugGraphicsOptions());
		clone.setDisabledIcon(this.getDisabledIcon());
		clone.setDisplayedMnemonic(this.getDisplayedMnemonic());
		clone.setDisplayedMnemonicIndex(this.getDisplayedMnemonicIndex());
		clone.setDropTarget(this.getDropTarget());
		clone.setFocusTraversalKeysEnabled(this.getFocusTraversalKeysEnabled());
		clone.setFocusTraversalPolicy(this.getFocusTraversalPolicy());
		clone.setFont(this.getFont());
		clone.setForeground(this.getForeground());
		clone.setHorizontalAlignment(this.getHorizontalAlignment());
		clone.setHorizontalTextPosition(this.getHorizontalTextPosition());
		clone.setIcon(this.getIcon());
		clone.setIconTextGap(this.getIconTextGap());
		clone.setIgnoreRepaint(this.getIgnoreRepaint());
		clone.setInheritsPopupMenu(this.getInheritsPopupMenu());
		clone.setInputVerifier(this.getInputVerifier());
		clone.setInputMap(WHEN_IN_FOCUSED_WINDOW, this.getInputMap(WHEN_IN_FOCUSED_WINDOW));
		clone.setInputMap(WHEN_FOCUSED, this.getInputMap(WHEN_FOCUSED));
		clone.setInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, this.getInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT));
		clone.setLabelFor(this.getLabelFor());
		clone.setLayout(this.getLayout());
		clone.setLocale(this.getLocale());
		clone.setLocation(this.getLocation());
		clone.setMaximumSize(this.getMaximumSize());
		clone.setMinimumSize(this.getMinimumSize());
		clone.setName(this.getName());
		clone.setPreferredSize(this.getPreferredSize());
		clone.setSize(this.getSize());
		clone.setText(this.getText());
		clone.setToolTipText(this.getToolTipText());
		clone.setTransferHandler(this.getTransferHandler());
		clone.setUI(this.getUI());
		clone.setVerifyInputWhenFocusTarget(this.getVerifyInputWhenFocusTarget());
		clone.setVerticalAlignment(this.getVerticalAlignment());
		clone.setVerticalTextPosition(this.getVerticalTextPosition());
		return clone;
	}
	
	
}
