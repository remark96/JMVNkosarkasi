package view;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.security.auth.Refreshable;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Cetvrtina;
import model.StatistikaIgraca;
import model.StatistikaTrenera;
import model.Sut;
import model.VrstaSuta;

@SuppressWarnings("serial")
class VerticalMenuBar extends JMenuBar {
	DecimalFormat df = new DecimalFormat("#.##");
	  private static final LayoutManager grid = new GridLayout(0,1);
	  private JPanel page;
	  //private Controller controller;
	  
	  private static DefaultTableModel tm=new DefaultTableModel(){
	      public boolean isCellEditable(double rowIndex, double mColIndex) {
	          return false;
	        }
	  };
	  
	  public VerticalMenuBar(JPanel page) {
		//  this.controller = controller;
		  this.page = page;
		  setLayout(grid);
	  }

//	  public Controller getController() {
//			return controller;
//		}
//
//		public void setController(Controller controller) {
//			this.controller = controller;
//		}

	public JPanel getPage() {
		return page;
	}

	public void setPage(JPanel page) {
		this.page = page;
	}
	  
	
	public void prikaziStatistikuTrenera(StatistikaTrenera statistikaTrenera,boolean domaci) {
		  reset();
		  tm.setColumnIdentifiers(new String[] {"Broj tajmauta","Tehnicke greske","Izmene"});
		 
		  PageForReports pageForReports = (PageForReports) page;
			PageForStatistikaTrenera pageForStatistikaTrenera;
			if (domaci) pageForStatistikaTrenera = pageForReports.getPageForStatistikaDomacegTrenera();
			else pageForStatistikaTrenera = pageForReports.getPageForStatistikaGostujucegTrenera();
			
			pageForStatistikaTrenera.getTabela().setModel(tm);
			tm.addRow(new String[]{statistikaTrenera.getTimeouts().size()+"",statistikaTrenera.getTehnickeGreske()+"","Click here..."});
			
			pageForReports.putPageForStatistikaTrenera(pageForStatistikaTrenera);
		
	  }
		  
	  
	  public void prikaziStatistikuEkipe(ArrayList<StatistikaIgraca>lista,boolean domaci) {
		  	reset();
			tm.setColumnIdentifiers(new String[] {"Ime i prezime igraca","PTS","REB","AST","BLK","FGM","FGA","FG%",
					"3PM","3PA","3P%","FTM","FTA","FT%","OREB","DREB","TOV","TF","PF","index"});
			String ime="";
			String prezime="";
			double pts=0;double reb=0;double ast=0;double blk=0;
			double fgm=4;double fga=8;double fgp=0;double oreb=0;double dreb=0;
			double tov=0;double pf=0;double tf=0;double index=0;double ft=10;
			double fta=11;double ftp=0;double s2=0;double s2a=0; double s2p=0;double s3=0;double s3a=0;double s3p=0;
			double ptsU=0; double rebU=0;double astU=0;double blkU=0;
			double fgmU=4;double fgaU=8;double fgpU=0;double orebU=0;double drebU=0;
			double tovU=0;double pfU=0;double tfU=0;double ftU=0;double ftaU=0;double ftpU=0;double s2U=0;
			double s2aU=0;double s2pU=0;double s3U=0;double s3aU=0; double s3pU=0;
			
			for (StatistikaIgraca statistikaIgraca:lista){
				
				for (Cetvrtina cetvrtina:statistikaIgraca.getCetvrtine()){
					pf+=cetvrtina.getLicne_greske1()+cetvrtina.getLicne_greske2()+cetvrtina.getLicne_greske3();
					pfU+=pf;
					reb+=cetvrtina.getDef_skokovi()+cetvrtina.getOfa_skokovi();
					ast+=cetvrtina.getAsistencije();
					blk+=cetvrtina.getBlokade();
					oreb+=cetvrtina.getOfa_skokovi();
					dreb+=cetvrtina.getDef_skokovi();
					tov+=cetvrtina.getDuplaLopta()+cetvrtina.getKoraci()+cetvrtina.getLoseDodavanje()+cetvrtina.getLoseHvatanje()+cetvrtina.getPrekoPola();
					tf+=cetvrtina.getTehnicke_greske();
					tfU+=tf;
					for (Sut sut:cetvrtina.getSutevi()){
						if (sut.isPogodak()){
							if (sut.getVrsta()==VrstaSuta.jedanPoen){
								pts+=1;
								ft+=1;
								fta+=1;
							}
							if (sut.getVrsta()==VrstaSuta.dvaPoena){
								s2+=1;
								s2a+=1;
								pts+=2;
								fgm+=1;
								fga+=1;
							}
							if (sut.getVrsta()==VrstaSuta.triPoena){
								s3+=1;
								s3a+=1;
								pts+=3;
								fgm+=1;
								fga+=1;
							}
						else if (!sut.isPogodak()){
							if (sut.getVrsta()==VrstaSuta.jedanPoen){
								fta+=1;
							}
							if (sut.getVrsta()==VrstaSuta.dvaPoena){
								s2a+=1;
								fga+=1;
							}
							if (sut.getVrsta()==VrstaSuta.dvaPoena){
								s3a+=1;
								fga+=1;
							}
						}
						}
					
					}
					
					
				}
				
				rebU+=reb;drebU+=dreb;orebU+=oreb;astU+=ast;blkU+=blk;tovU+=tov;ptsU+=pts;
				ftU+=ft; ftaU+=fta;s3U+=s3;s2aU+=s2a;s3aU+=s3a;
				if (s3a!=0){
					s3p = s3/s3a*100;
					s3p = Double.valueOf(df.format(s3p));
				}
				else{
					s3p=0;
				}	
				if (fta!=0){
					ftp = ft/fta*100;
					ftp = Double.valueOf(df.format(ftp));
				}
				else{
					ftp=0;
				}
				if (fga!=0){
					fgp = fgm/fga*100;
					fgp = Double.valueOf(df.format(fgp));
				}
				else{
					fgp=0;
				}

				if (ftaU!=0){
					ftpU = ftU/ftaU*100;
					ftpU = Double.valueOf(df.format(ftpU));
				}
				else{
					ftpU=0;
				}
				if (s3aU!=0){
					s3pU = s3U/s3aU*100;
					s3pU = Double.valueOf(df.format(s3pU));
				}
				else{
					s3pU=0;
				}		
				if (fgaU!=0){
					fgpU = fgmU/fgaU*100;
					fgpU = Double.valueOf(df.format(fgpU));
				}
				else{
					fgpU=0;
				}

			
				index=pts+reb+ast-pf-tov-fga+blk;
				ime=statistikaIgraca.getIgrac().getIme();
				prezime=statistikaIgraca.getIgrac().getPrezime();
				//"Ime i prezime igraca", "P", "MIN", "PTS","REB","AST","BLK","FGM","FGA","FG%",
				//"3PM","3PA","3P%","FTM","FTA","FT%","OREB","DREB","TOV","TF","PF","+/-";
				tm.addRow(new String[]{ime+ " " +prezime,""+pts,""+reb,""+ast,""+blk,""+fgm,""+fga,""+fgp,
						""+s3,""+s3a,""+s3p,""+ft,""+fta,""+ftp,""+oreb,""+dreb,""+tov,""+tf,""+pf,""+index});
				pts=0;reb=0;ast=0;blk=0;fgm=0;fga=0;s3=0;s3a=0;s3p=0;ft=0;fta=0;ftp=0;oreb=0;dreb=0;tov=0;pf=0;index=0;tf=0;
				}
				
				tm.addRow(new String[]{"Ukupno",""+ptsU,""+rebU,""+astU,""+blkU,""+fgmU,""+fgaU,""+fgpU,
				""+s3U,""+s3aU,""+s3pU,""+ftU,""+ftaU,""+ftpU,""+orebU,""+drebU,""+tovU,tfU+"",pfU+"","    /"});
				
				PageForReports pageForReports = (PageForReports) page;
				PageForStatistikaEkipe pageForStatistikaEkipe;
				if (domaci) pageForStatistikaEkipe = pageForReports.getPageForStatistikaDomaceEkipe();
				else pageForStatistikaEkipe = pageForReports.getPageForStatistikaGostujuceEkipe();
				
				pageForStatistikaEkipe.getTabela().setModel(tm);
				
				pageForReports.putPageForStatistikaEkipe(pageForStatistikaEkipe);
			
	  }
	  void reset() {
		  tm.setRowCount(0);
		}
	  
	  public void signOut() {
		  MainWindow mainWindow = (MainWindow) SwingUtilities.windowForComponent(page);
		  /*
		   * TO DO
		   */
		  mainWindow.refresh();
	  }

	public void prikaziTimskuStatistiku(ArrayList<StatistikaIgraca>lista, boolean domaci){
		reset();
		tm.setColumnIdentifiers(new String[] {"Segment igre", "PTS","REB","AST","BLK","FGM","FGA","FG%","FGMK1","FGAK1","FG%K1","FGMK2","FGAK2","FG%K2","FGMK3","FGAK3","FG%K3","FGMK4","FGAK4","FG%K4","FGMK5","FGAK5","FG%K5","FGMK6","FGAK6","FG%K6",
				"3PM","3PA","3P%","FTM","FTA","FT%","TREB","OREB","DREB","5sTOV","TOV","TF","PF"});
		String ime="";
		double pts=0;double reb=0;double ast=0;double blk=0;double oreb=0;double dreb=0;
		double tov=0;double pf=0;double tf=0;double index=0;double ft=11;
		double fta=11;double ftp=0;double s2=0;double s2a=0;double s3=0;double s3a=0;
		double s3p=0;double fga=0;double fgm=0;
		double fgmk1=0; double fgak1=0; double fgpk1=0; double fgak2=0;double fgmk2=0; double fgpk2=0;
		double fgmk3=0; double fgak3=0;double fgpk3=0; double fgak4=0;double fgmk4=0; double fgpk4=0;
		double fgak5=0;double fgmk5=0; double fgpk5=0; double fgak6=0;double fgmk6=0; double fgpk6=0;
		for (StatistikaIgraca statistikaIgraca:lista){
			
			for (Cetvrtina cetvrtina:statistikaIgraca.getCetvrtine()){
				reb+=cetvrtina.getDef_skokovi()+cetvrtina.getOfa_skokovi();
				ast+=cetvrtina.getAsistencije();
				blk+=cetvrtina.getBlokade();
				oreb+=cetvrtina.getOfa_skokovi();
				dreb+=cetvrtina.getDef_skokovi();
				tov+=cetvrtina.getDuplaLopta()+cetvrtina.getKoraci()+cetvrtina.getLoseDodavanje()+cetvrtina.getLoseHvatanje()+cetvrtina.getPrekoPola();
				
				for (Sut sut:cetvrtina.getSutevi()){
					if (sut.isPogodak()){
						if (sut.getVrsta()==VrstaSuta.jedanPoen){
							pts+=1;
							ft+=1;
							fta+=1;
						}
						if (sut.getVrsta()==VrstaSuta.dvaPoena){
							if (sut.getKvadrant()==1) fgmk1+=1;fgak1+=1;
							if (sut.getKvadrant()==2) fgmk2+=1;fgak2+=1;
							if (sut.getKvadrant()==3) fgmk3+=1;fgak3+=1;
							if (sut.getKvadrant()==4) fgmk4+=1;fgak4+=1;
							if (sut.getKvadrant()==5) fgmk5+=1;fgak5+=1;
							if (sut.getKvadrant()==6) fgmk6+=1;fgak6+=1;
							s2+=1;
							s2a+=1;
							pts+=2;
							fgm+=1;
							fga+=1;
						}
						if (sut.getVrsta()==VrstaSuta.triPoena){
							if (sut.getKvadrant()==1) fgmk1+=1;fgak1+=1;
							if (sut.getKvadrant()==2) fgmk2+=1;fgak2+=1;
							if (sut.getKvadrant()==3) fgmk3+=1;fgak3+=1;
							if (sut.getKvadrant()==4) fgmk4+=1;fgak4+=1;
							if (sut.getKvadrant()==5) fgmk5+=1;fgak5+=1;
							if (sut.getKvadrant()==6) fgmk6+=1;fgak6+=1;
							s3+=1;
							s3a+=1;
							pts+=3;
							fgm+=1;
							fga+=1;
						}
					else if (!sut.isPogodak()){
						if (sut.getVrsta()==VrstaSuta.jedanPoen){
							fta+=1;
						}
						if (sut.getVrsta()==VrstaSuta.dvaPoena){
							if (sut.getKvadrant()==1) fgak1+=1;
							if (sut.getKvadrant()==2) fgak2+=1;
							if (sut.getKvadrant()==3) fgak3+=1;
							if (sut.getKvadrant()==4) fgak4+=1;
							if (sut.getKvadrant()==5) fgak5+=1;
							if (sut.getKvadrant()==6) fgak6+=1;
							s2a+=1;
							fga+=1;
						}
						if (sut.getVrsta()==VrstaSuta.triPoena){
							if (sut.getKvadrant()==1) fgak1+=1;
							if (sut.getKvadrant()==2) fgak2+=1;
							if (sut.getKvadrant()==3) fgak3+=1;
							if (sut.getKvadrant()==4) fgak4+=1;
							if (sut.getKvadrant()==5) fgak5+=1;
							if (sut.getKvadrant()==6) fgak6+=1;
							s3a+=1;
							fga+=1;
						}
					}
					}
				
				}
				
				
				
				
				
			}
		if (fta!=0){
			ftp = ft/fta*100;
		}
		else{
			ftp=0;
		}
		if (s3a!=0){
			s3p = s3/s3a*100;
		}
		else{
			s3p=0;
		}
		}
		for (StatistikaIgraca statistikaIgraca1:lista) {
			ime=statistikaIgraca1.getIgrac().getIme();
			//"Ime i prezime igraca", "P", "MIN", "PTS","REB","AST","BLK","FGM","FGA","FG%",
			//"3PM","3PA","3P%","FTM","FTA","FT%","OREB","DREB","TOV","TF","PF","+/-";
			tm.addRow(new String[]{ime, "","",""+pts,"",""+reb,""+ast,""+blk,""+fgm,""+fga,
					""+s3,""+s3,""+s3p,""+ft,""+fta,""+ftp,""+oreb,""+dreb,""+tov,"",""});
			}
		PageForReports pageForReports = (PageForReports) page;
		PageForStatistikaEkipe pageForStatistikaEkipe;
		if (domaci) pageForStatistikaEkipe = pageForReports.getPageForStatistikaDomaceEkipe();
		else pageForStatistikaEkipe = pageForReports.getPageForStatistikaDomaceEkipe();
		
		pageForStatistikaEkipe.getTabela().setModel(tm);
		
		
		
}


	public void prikaziStatistikuIgracaDomaceEkipe() { 
		PageForReports pageForReports = (PageForReports) page;
		PageForStatistikeIgraca pageForStatistikeIgraca = pageForReports.getPageForStatistikeDomacihIgraca();
		pageForReports.putPageForStatistikaIgraca(pageForStatistikeIgraca);
		
	}
	public void prikaziStatistikuIgracaGostujuceEkipe() { 
		PageForReports pageForReports = (PageForReports) page;
		PageForStatistikeIgraca pageForStatistikeIgraca = pageForReports.getPageForStatistikeGostujucihIgraca();
		pageForReports.putPageForStatistikaIgraca(pageForStatistikeIgraca);
		
	}
	
	public void prikaziStatistikuEkipe(PageForStatistikaEkipe pageForStatistikaEkipe) { 
		PageForReports pageForReports = (PageForReports) page;
		pageForReports.putPageForStatistikaEkipe(pageForStatistikaEkipe);
	}


	public void prikaziOsnovnePodatkeZaUtakmicu() {
		((PageForReports) page).putPagePageBasicInformationForUtakmica();
		
	}
	  
}
