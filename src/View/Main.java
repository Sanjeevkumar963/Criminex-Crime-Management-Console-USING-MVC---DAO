package View;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Controller.DTO.CaseDetails;
import Controller.DAO.CaseDetailsDAO;
import Controller.DTO.CrimeDetails;
import Controller.DAO.CrimeDetailsDAO;
import Controller.DTO.LoginDetails;
import Controller.DAO.LoginDetailsDAO;
import Controller.DTO.PrisonerDetails;
import Controller.DAO.PrisonerDetailsDAO;
import Controller.DTO.Suspects;
import Controller.DAO.SuspectsDAO;
import Model.*;

public class Main 
{
	static LoginDetailsDAO l=new LoginDetailsDAOImpl();
	static SuspectsDAO s=new SuspectsDAOImpl();
	static CrimeDetailsDAO cd=new CrimeDetailsDAOImpl();
	static CaseDetailsDAO cad=new CaseDetailsDAOImpl();
	static PrisonerDetailsDAO pds=new PrisonerDetailsDAOImpl();
	static Suspects suspect=new Suspects();
	static CrimeDetails crimeD=new CrimeDetails();
	static CaseDetails caseD=new CaseDetails();
	static PrisonerDetails prisoner=new PrisonerDetails();

	public static void main(String arg[]) throws SQLException, ParseException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println("										WELCOME TO CRIMINAL DATABASE");
		System.out.println();
		while(true) 
		{
			System.out.println("            								+--------------------------------------------------+");
			System.out.println("            								|   1    |      Login                              |");
			System.out.println("            								|--------------------------------------------------|");
			System.out.println("									|   2    |      Sign Up                            |");
			System.out.println("									|--------------------------------------------------|");
			System.out.println("									|   3    |      Exit                               |");
			System.out.println("									+--------------------------------------------------|");
			System.out.println();
			System.out.print("										Enter Your Choice : ");	
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) 
            {
                case 1:
                	System.out.println("            								+---------------------------------------------------+");
        			System.out.print("            								    Enter Your Mail Id      :");
        			String email=sc.nextLine();
        			System.out.print("            								    Enter Your Mail Password:");
        			String password=sc.nextLine();
        			System.out.println("            								+---------------------------------------------------+");
        			LoginDetails login=l.getByEmail(email, password);
        			if(login!=null) 
        			{
        				String res=login.getRole();
        				if(res.equals("Admin"))
        				{
        					while(true)
        					{
        						System.out.println("            							     +--------------------------------------------------------+");
        						System.out.println("            							     |                     ADMIN OPTIONS                      |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   1    |      Add a Suspect                            |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   2    |      View all Suspects by Gender              |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   3    |      View All Suspects                        |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   4    |      View All Suspects By Suspect ID          |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   5    |      View All Suspects By Guilty Status       |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   6    |      Add Crime Details                        |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   7    |      View Crime Details By Crime              |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   8    |      View All Crime Details By Guilty Status  |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   9    |      Add Case Details                         |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   10   |      View Case Details By Case Number         |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   11   |      View Case Details By Judgements          |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   12   |      Update Judgements                        |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   13   |      Regular Case Updation                    |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println("            							     |   14   |      Exit                                     |");
        						System.out.println("            							     |--------------------------------------------------------|");
        						System.out.println();
        						System.out.print("										Enter Your Choice : ");
        						int choice1 = sc.nextInt();
        						sc.nextLine();
        						switch (choice1) 
        						{
        						case 1:
        							System.out.println("            								+---------------------------------------------------+");
        							System.out.print("            								    Enter Suspect ID           :");
        							String suspect_id=sc.nextLine();
        							System.out.print("            								    Enter Suspect name         :");
        							String name=sc.nextLine();
        							System.out.print("            								    Enter Suspect Gender       :");
        							String gender=sc.nextLine();
        							System.out.print("            								    Enter Suspect DOB          :");
        							String DOB=sc.nextLine();
        							System.out.print("            								    Enter number of cases     :");
        							int no_of_cases=0;
        							System.out.println("            								+---------------------------------------------------+");
        							SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        							Date date = dateFormat.parse(DOB);
//        							Suspects suspect=new Suspects(suspect_id,name,gender,date,no_of_crime);
        							suspect.setSuspect_id(suspect_id);
        							suspect.setName(name);
        							suspect.setGender(gender);
        							suspect.setDate_of_Birth(date);
        							suspect.setNo_of_cases(no_of_cases);
        							s.insert(suspect);
        							break;
        						case 2:
        							System.out.println("            								+---------------------------------------------------+");
        							System.out.print("            								    Enter Gender           :");
        							String gender1=sc.nextLine();
        		        			System.out.println("            								+---------------------------------------------------+");
        							List<Suspects> suspectList=s.retrieveAllByGender(gender1);
        							for (Suspects suspect1 : suspectList) 
        							{
        								System.out.println("            								+---------------------------------------------------+");
        								System.out.println("            								  Suspect ID      : " + suspect1.getSuspect_id());
        								System.out.println("            								  Name            : " + suspect1.getName());
        								System.out.println("            								  Gender          : " + suspect1.getGender());
        								System.out.println("            								  Date of Birth   : " + suspect1.getDate_of_Birth());
        								System.out.println("            								  Number of Cases : " + suspect1.getNo_of_cases());
        								System.out.println("            								+---------------------------------------------------+");
        							}
        		        			break;
        						case 3:
        							System.out.println("            									List Of Suspects");
        							List<Suspects> suspectList1=s.retrieveAll();
        							for (Suspects suspect1 : suspectList1) 
        							{
        								System.out.println("            								+---------------------------------------------------+");
        								System.out.println("            								  Suspect ID      : " + suspect1.getSuspect_id());
        								System.out.println("            								  Name            : " + suspect1.getName());
        								System.out.println("            								  Gender          : " + suspect1.getGender());
        								System.out.println("            								  Date of Birth   : " + suspect1.getDate_of_Birth());
        								System.out.println("            								  Number of Cases : " + suspect1.getNo_of_cases());
        								System.out.println("            								+---------------------------------------------------+");
        							}
        							break;
        						case 4:
        						    System.out.print("            									Enter Suspect ID: ");
        						    String suspectIdInput = sc.nextLine();
        						    suspect = s.retrieveSuspectById(suspectIdInput);
        						    if (suspect != null) 
        						    {
        						        System.out.println("            								+---------------------------------------------------+");
        						        System.out.println("              								Suspect ID      : " + suspect.getSuspect_id());
        						        System.out.println("              								Name            : " + suspect.getName());
        						        System.out.println("              								Gender          : " + suspect.getGender());
        						        System.out.println("              								Date of Birth   : " + suspect.getDate_of_Birth());
        						        System.out.println("              								Number of Cases : " + suspect.getNo_of_cases());
        						        System.out.println("            								+---------------------------------------------------+");
        						    } 
        						    else 
        						    {
        						        System.out.println("            								No suspect found with ID: " + suspectIdInput);
        						    }
        						    break;

        						case 5:
        							System.out.print("            									Enter Guilty Status:");
        							String status=sc.nextLine();
        							List<Suspects> suspectList2=s.retrieveAllSuspectsByGuiltyStatus(status);
        							System.out.println("            									List Of Suspects whose Guilty Status is "+status);
        							for (Suspects sus : suspectList2) 
        							{
        								System.out.println("            								+---------------------------------------------------+");
        								System.out.println("            								  Suspect ID      : " + sus.getSuspect_id());
        								System.out.println("            								  Name            : " + sus.getName());
        								System.out.println("            								  Gender          : " + sus.getGender());
        								System.out.println("            								  Date of Birth   : " + sus.getDate_of_Birth());
        								System.out.println("            								  Number of Cases : " + sus.getNo_of_cases());
        								System.out.println("            								+---------------------------------------------------+");
        							}
        							break;
        						case 6:
        							System.out.println("            								+---------------------------------------------------+");
        							System.out.print("            								    Enter FIR NO            :");
        							String fir=sc.nextLine();
        							System.out.print("            								    Enter Suspect ID        :");
        							String suspect_id1=sc.nextLine();
        							System.out.print("            								    Enter Crime committed   :");
        							String crime=sc.nextLine();
        							System.out.print("            								    Enter Guilty Status     :");
        							String guilt_status=sc.nextLine();
        							System.out.print("            								    Enter Date Of Arrest    :");
        							String date_of_arrest=sc.nextLine();
        							System.out.println("            								+---------------------------------------------------+");
        							SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
        							Date date1 = dateFormat1.parse(date_of_arrest);
        							crimeD.setFir_no(fir);
        							crimeD.setSuspect_id(suspect_id1);
        							crimeD.setCrime(crime);
        							crimeD.setGuilty_status(guilt_status);
        							crimeD.setDate_of_arrest(date1);
        							cd.insert(crimeD);
        							break;
        						case 7:
        							System.out.print("            									Enter Crime:");
        							String crime1=sc.nextLine();
        							List<CrimeDetails> crimeDetailsList=cd.retrieveAllByCrime(crime1);
        							System.out.println("            									List Of Crime Details Based on crime: "+crime1);
        							for (CrimeDetails cds : crimeDetailsList) 
        							{
        								System.out.println("            								+---------------------------------------------------+");
        								System.out.println("            								  FIR NO          : " + cds.getFir_no());
        								System.out.println("            								  Suspect_id      : " + cds.getSuspect_id());
        								System.out.println("            								  Crime           : " + cds.getCrime());
        								System.out.println("            								  Guilty Status   : " + cds.getGuilty_status());
        								System.out.println("            								  Date Of Arrest  : " + cds.getDate_of_arrest());
        								System.out.println("            								+---------------------------------------------------+");
        							}
        							break;
        						case 8:
        							System.out.print("            									Enter guilty Status:");
        							String guilty=sc.nextLine();
        							List<CrimeDetails> crimeDetailsList1=cd.retrieveAllByGuiltyStatus(guilty);
        							System.out.println("            									List Of Crime Details Based on Guilty Status: "+guilty);
        							for (CrimeDetails cds : crimeDetailsList1) 
        							{
        								System.out.println("            								+---------------------------------------------------+");
        								System.out.println("            								  FIR NO          : " + cds.getFir_no());
        								System.out.println("            								  Suspect_id      : " + cds.getSuspect_id());
        								System.out.println("            								  Crime           : " + cds.getCrime());
        								System.out.println("            								  Guilty Status   : " + cds.getGuilty_status());
        								System.out.println("            								  Date Of Arrest  : " + cds.getDate_of_arrest());
        								System.out.println("            								+---------------------------------------------------+");
        							}
        							break;
        						case 9:
        							System.out.println("            								+---------------------------------------------------+");
        							System.out.print("            								    Enter Case No       :");
        							String case_no=sc.nextLine();
        							System.out.print("            								    Enter Filing Date   :");
        							String filing_date=sc.nextLine();
        							System.out.print("            								    Enter Case Date     :");
        							String case_date=sc.nextLine();
        							System.out.print("            								    Enter Advocate ID   :");
        							String ddvocate_id=sc.nextLine();
        							System.out.print("            								    Enter FIR NO        :");
        							String fir1=sc.nextLine();
        							System.out.print("            								    Enter Judgement     :");
        							String judgement=sc.nextLine();
        							System.out.println("            								+---------------------------------------------------+");
        							SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
        							Date date2 = dateFormat2.parse(filing_date);
        							SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd-MM-yyyy");
        							Date date3 = dateFormat3.parse(case_date);
        							caseD.setCase_no(case_no);
        							caseD.setFiling_date(date2);
        							caseD.setCase_date(date3);
        							caseD.setAdvocate_id(ddvocate_id);
        							caseD.setFir_no(fir1);
        							caseD.setJudgement(judgement);
        							cad.insert(caseD);
        							break;
        						case 10:
        							System.out.print("            									Enter Case number: ");
        						    String case_no1 = sc.nextLine();
        						    caseD= cad.getCaseDetailsByCaseNo(case_no1);
        						    if (caseD != null) 
        						    {
        						        System.out.println("            								+---------------------------------------------------+");
        						        System.out.println("              								Case Number : " + caseD.getCase_no());
        						        System.out.println("              								FIR NO      : " + caseD.getFir_no());
        						        System.out.println("              								Filing date : " + caseD.getFiling_date());
        						        System.out.println("              								Case Date   : " + caseD.getCase_date());
        						        System.out.println("              								Advocate ID : " + caseD.getAdvocate_id());
        						        System.out.println("              								Judgement   : " + caseD.getJudgement());
        						        System.out.println("            								+---------------------------------------------------+");
        						    } 
        						    else 
        						    {
        						        System.out.println("            								No Case found with Case Number: " + case_no1);
        						    }
        						    break;
        						case 11:
	        						System.out.print("            									Enter Judgement:");
	    							String jud=sc.nextLine();
	    							List<CaseDetails> cd1 = cad.retrieveCasesByJudgement(jud);
	    							System.out.println("            								List Of Cases based on Judgement");
	    							for (CaseDetails caseD : cd1) 
	    							{
	    							    System.out.println("            								+---------------------------------------------------+");
	    							    System.out.println("            								Case Number : " + caseD.getCase_no());
	    							    System.out.println("            								FIR NO      : " + caseD.getFir_no());
	    							    System.out.println("            								Filing date : " + caseD.getFiling_date());
	    							    System.out.println("            								Case Date   : " + caseD.getCase_date());
	    							    System.out.println("            								Advocate ID : " + caseD.getAdvocate_id());
	    							    System.out.println("            								Judgement   : " + caseD.getJudgement());
	    							    System.out.println("            								+---------------------------------------------------+");
	    							}

	    							break;
        						case 12:
        							System.out.print("            									Enter Case Number to be updated:");
        							String caseno=sc.nextLine();
        							caseD=cad.getCaseDetailsByCaseNo(caseno);
        							System.out.println("            									Enter Judgement to be updated:");
        							String judge=sc.nextLine();
        							cad.update(caseD, judge);
        							break;
        						case 13:
//        							System.out.println("regular Case Updation");
	    							List<CaseDetails> cd2 = cad.retrieveAll();
	    							for (CaseDetails cased : cd2) 
	    							{
	    							    
	    							    String h=cased.getJudgement();
	    							    switch(h) 
	    							    {
		    							    case "Imprisoned":
		            							System.out.println("            									Enter Prisoner ID:");
		            							String p=sc.nextLine();
		            							System.out.println("            									Enter Prison ID:");
		            							String ps=sc.nextLine();
		            							String crimedone=cd.getCrimeSuspectId(cased.getFir_no());
		            							Date d=cd.calculateReleaseDate(crimedone,cased.getCase_date());
		            							prisoner.setPrisoner_id(p);
		            							prisoner.setPrison_id(ps);
		            							prisoner.setSuspect_id(cd.getSuspectId(cased.getFir_no()));
		    							    	prisoner.setDate_of_imprisonment(cased.getCase_date());
		    							    	prisoner.setDate_of_release(d);
		    							    	pds.insert(prisoner);
		    							    	break;
		    							    case "Released":
		    							    	break;
		    							    case "Next Session":
		    							    	break;
	    							    }
	    							}
        							break;
        						case 14:
        							System.out.println("            									Exiting Database...");
        							sc.close();
        							System.exit(0);
        						default:
        							System.out.println("            									Invalid choice. Please try again.");
        						}
        					}
        				}
        				else if(res.equals("Attendant"))
        				{

        					System.out.println("            							     +--------------------------------------------------------+");
        					System.out.println("            							     |                     Welcome Attendent!!!               |");
        					System.out.println("            							     |--------------------------------------------------------|");
        					System.out.println("            							     |--------------------------------------------------------|");
    						System.out.println("            							     |   1    |      View Case Status                         |");
    						System.out.println("            							     |--------------------------------------------------------|");
    						System.out.println("            							     |--------------------------------------------------------|");
    						System.out.println("            							     |   2    |      Reappeal For a case                      |");
    						System.out.println("            							     |--------------------------------------------------------|");
    						System.out.println();
    						System.out.print("										Enter Your Choice : ");	
    						int choice3 = sc.nextInt();
    						sc.nextLine();
    						switch (choice3) 
    			            {
    			                case 1:
    			                	System.out.println("Case status");
    			                	break;
    			                case 2:
    			                	System.out.println("Reappeal");
    			                default:
    			                	break;
    			            }   		
        				}
        			} 
        			else
        			{
        				System.out.println("            								Invalid email or password.");
        			}
                    break;
                case 2:
                	System.out.println();
                    System.out.println("            									SignUp Options");
                	System.out.println();
                    break;
                case 3:
                	System.out.println();
                    System.out.println("            									Exiting Database...");
                	System.out.println();
                    sc.close();
                    System.exit(0);
                default:
                	System.out.println();
                    System.out.println("            									Invalid choice. Please try again.");
                	System.out.println();
            }
		}
	}
}
