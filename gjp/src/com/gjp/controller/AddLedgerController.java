package com.gjp.controller;

import javax.swing.JDialog;

import com.gjp.view.AbstractOperationLedgerDialog;

public class AddLedgerController extends AbstractOperationLedgerDialog {

	public AddLedgerController(JDialog dialog) {
		super(dialog);
		titleLabel.setText("添加账务");
		super.setTitle("添加账务");
	}

	@Override
	public void changeParent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirm() {
		// TODO Auto-generated method stub

	}

}
