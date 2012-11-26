package com.example.projectvaadin.domain;

public class Dane {

	private String _imie = "unknown";
	private String _nazwisko = "unknown";
	private String telefon = "586640466";
	private String email= "unknown@gmail.pl";
	
	public Dane(String imie, String nazwisko, String telefon, String email) {
		this._imie = imie;
		this._nazwisko = nazwisko;
		this.telefon = telefon;
		this.email = email;
	}
	public Dane() {
		
	}
	public String get_Imie() {
		return _imie;
	}
	public void set_Imie(String imie) {
		this._imie = imie;
	}
	public String get_Nazwisko() {
		return _nazwisko;
	}
	public void set_Nazwisko(String nazwisko) {
		this._nazwisko = nazwisko;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){
		return "Imie " + _imie + " " + "Nazwisko " + _nazwisko + " "+  "Telefon " + telefon + " ";
	}


}
