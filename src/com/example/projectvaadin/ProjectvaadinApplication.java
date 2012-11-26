package com.example.projectvaadin;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.projectvaadin.domain.Dane;
import com.vaadin.Application;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Validator;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window.Notification;


public class ProjectvaadinApplication extends Application {
	
	
	
	private static final long serialVersionUID = 1L;
	private Window mainWindow = new Window();
	
	
	
	BeanItemContainer<Dane> daneContainer;
	
	
	@Override
	public void init() {
		daneContainer = new BeanItemContainer<Dane>(Dane.class);
		final Table daneTable = new Table("",daneContainer);
	     daneTable.setWidth("400px");
	     daneTable.setHeight("200px");
		 initData();
		final Form daneForm = new Form();
		 daneForm.setCaption("Podaj dane : ");
		
		 daneForm.setVisibleItemProperties(Arrays.asList(new String[] {
	             "_imie", "_nazwisko", "email", "telefon"
	             }));
		 

		  
		 final Dane dane = new Dane();
		 final BeanItem<Dane> daneItem = new  BeanItem<Dane>(dane);
		 
		 daneForm.setItemDataSource(daneItem);
		 daneForm.setWriteThrough(false);
		 
		 mainWindow.addComponent(daneForm);
		 
		 Button dodaj = new Button("Dodaj dane",new Button.ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
			
				//getMainWindow().showNotification(dane.get_Imie());
				daneForm.commit();
				
				daneContainer.addItem(new Dane(dane.get_Imie(), dane.get_Nazwisko(), dane.getTelefon(), dane.getEmail()));
				getMainWindow().showNotification("Dodano : "+Integer.toString(daneContainer.size()));
			}
		});
		 
		 HorizontalLayout layout = new HorizontalLayout();
		 mainWindow.addComponent(layout);
		 
		 layout.addComponent(dodaj);
		 
		 
		//update
			
			final Button edit = new Button("Edytuj");
			
			layout.addComponent(edit);
			
			edit.addListener(new Button.ClickListener() {
				
				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					
					daneTable.setEditable(!daneTable.isEditable());
					edit.setCaption((daneTable.isEditable() ? "Zapisz" : "Edytuj"));
					
				}
			});
			
		
			Button usun = new Button("Usun");
			
			layout.addComponent(usun);
			
			usun.addListener(new Button.ClickListener() {
				
				public void buttonClick(ClickEvent event) {
					
			
						daneTable.removeItem(daneTable.getValue());
						daneTable.select(null);
						
				
				
					
				}
			}); 
		
		
		mainWindow.addComponent(daneTable);

		daneTable.setSelectable(true);
		daneTable.setImmediate(true);
		
		daneTable.addListener(new Table.ValueChangeListener() {

			private static final long serialVersionUID = 1L;
			public void valueChange(ValueChangeEvent event) {
				if (daneTable.getValue() != null) {
					mainWindow.showNotification("" + daneTable.getValue(), Notification.TYPE_TRAY_NOTIFICATION);
				}
			}
		
		
		
		
		});
		
		
		
		//Window mainWindow = new Window("Projectvaadin Application");
		//Label label = new Label("Hello Vaadin user");
		//mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}
	
	private List<Dane> dane = new ArrayList<Dane>();
	
	public void dodajDane(Dane dn) {
	daneContainer.addItem(dn);
	}
	
	
	
	
	
	private void initData(){
		
		Dane d1 = new Dane();
		d1.set_Imie("Aneta");
		d1.set_Nazwisko("Budner");
		d1.setTelefon("565858565");
		d1.setEmail("aneta57@o2.pl");
		dodajDane(d1);

	
	}
	


	

}
