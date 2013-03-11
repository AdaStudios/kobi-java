package com.ada.sme.controller;

import com.ada.sme.main.Product;
import com.ada.sme.model.FileModel;
import com.ada.sme.model.StatusModel;
import com.ada.sme.model.StockModel;
import com.ada.sme.view.StockView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StockController {
	private StockModel s_model;
	private StockView s_view;
	private FileModel f_model;
	private StatusModel stat_model;
	private String filename = "offlinestock.bin";
	public static ArrayList<String> commits = new ArrayList<String>();

	public StockController(StockModel model, StockView view) {
		super();
		this.s_model = model;
		this.s_view = view;
		this.f_model = new FileModel(filename);
		this.stat_model = new StatusModel("139.179.139.112");
		// commits= new ArrayList<String>();

		view.addSearchListener(new SearchListener());
		view.addInsertListener(new InsertListener());
		view.addDeleteListener(new DeleteListener());
		view.addUpdateListener(new UpdateListener());

		f_model.updateFile();
	}

	class SearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String input;
			input = s_view.getSearchInput();
			stat_model.check();
			if (stat_model.getStatus())
				s_model.search(input);
			else
				s_model.searchOffline(input);

			s_view.setSearch(s_model.getSearch());
		}
	}

	class InsertListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Product input;
			int ans = 0;
			input = s_view.getInsertObject();
			stat_model.check();
			if (stat_model.getStatus()) {
				ans = s_model.add(input);
				f_model.updateFile();
			} else {
				String com = s_model.addOffline(input);
				commits.add(com);
				ans = 1;
			}
			s_view.notifyAdd(ans);

		}
	}

	class UpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("hebere");
			Product input;
			int ans = 0;
			input = s_view.getUpdateObject();
			stat_model.check();
			if (stat_model.getStatus()) {
				ans = s_model.update(input);
				f_model.updateFile();
			} else {
				String com = s_model.updateOffline(input);
				commits.add(com);
				ans = 1;
			}
			s_view.notifyUpdate(ans);
		}
	}

	class DeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String input;
			input = s_view.getId();
			int ans=0;
			stat_model.check();
			if (stat_model.getStatus()) {				
				ans = s_model.delete(Integer.valueOf(input));				
			}else{
				String com = s_model.deleteOffline(Integer.valueOf(input));
				commits.add(com);
				ans = 1;
			}
			s_view.notifyDel(ans);  
		}
	}

}
