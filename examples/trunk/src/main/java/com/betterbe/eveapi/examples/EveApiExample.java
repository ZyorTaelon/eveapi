package com.betterbe.eveapi.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.beimin.eveapi.EveApi;
import com.beimin.eveapi.account.apikeyinfo.ApiKeyInfoResponse;
import com.beimin.eveapi.account.characters.EveCharacter;
import com.beimin.eveapi.api.calllist.Call;
import com.beimin.eveapi.api.calllist.CallGroup;
import com.beimin.eveapi.api.calllist.CallList;
import com.beimin.eveapi.core.ApiAuthorization;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.KeyType;
import com.beimin.eveapi.shared.accountbalance.EveAccountBalance;
import com.beimin.eveapi.utils.AccessChecker;

public class EveApiExample extends Thread {
	private EveApi api = null;
	private Scanner scanner = null;
	private CallList callList = null;

	public static void main(String[] args) {
		EveApiExample example = new EveApiExample();
		example.start();
	}
	
	@Override
	public void run() {
		scanner = new Scanner(System.in);
		try {
			api = new EveApi();
			login();
			doUserActions();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		scanner.close();
	}

	private void login() throws ApiException {
		ApiAuthorization auth = getApiAuth();
		api.setAuth(auth);
		System.out.println("EveApi initialized... retrieving character list associated with the api key.");
		selectCharacter();
	}

	private ApiAuthorization getApiAuth() {
		System.out.println("Please enter a keyID: ");
		String keyIDs = scanner.nextLine();
		int keyID = Integer.parseInt(keyIDs);

		System.out.println("Please enter the verification code: ");
		String vCode = scanner.nextLine();
		ApiAuthorization auth = new ApiAuthorization(keyID, vCode);
		return auth;
	}

	private void doUserActions() {
		System.out.println("Choose which call you want to execute.");
		System.out.println("'CallList' shows you which calls are supported by the current API key.");
		boolean running = true;
		while(running) {
			String command = scanner.nextLine();
			try {
				if("CallList".equals(command))
					printCallList();
				else if("login".equals(command))
					login();
				else if("AccountBalance".equals(command))
					printAccountBalance();
				else
					System.out.println("Unknown command '"+command+"' Choose again.");
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
	}

	private void printAccountBalance() throws ApiException {
		String name = "AccountBalance";
		boolean characterAccess = hasAccess(name, KeyType.Character);
		boolean corporationAccess = hasAccess(name, KeyType.Corporation);
		KeyType type = null;
		if(characterAccess && corporationAccess) {
			System.out.println("Choose 1 for character account balance or 2 for corporation account balance");
			String choice = scanner.nextLine();
			if(choice.equals("1"))
				type = KeyType.Character;
			else if(choice.equals("2"))
				type = KeyType.Corporation;
		} else if(characterAccess)
			type = KeyType.Character;
		else if(corporationAccess)
			type = KeyType.Corporation;
		else {
			System.out.println("No access to the AccountBalance with current API key.");
			return;
		}
		List<EveAccountBalance> accountBalance = new ArrayList<EveAccountBalance>(api.getAccountBalance(type));
		if(accountBalance.size()>1)
			Collections.sort(accountBalance, new Comparator<EveAccountBalance>() {
				public int compare(EveAccountBalance o1, EveAccountBalance o2) {
					if(o1.getAccountID()!=o2.getAccountID())
						return o1.getAccountID() - o2.getAccountID();
					return o1.getAccountKey()-o2.getAccountKey();
				}
			});
		for (EveAccountBalance eveAccountBalance : accountBalance) {
			System.out.println(eveAccountBalance);
		}
	}

	private boolean hasAccess(String name, KeyType type) throws ApiException {
		for (Call call : getCalllList().getCalls())
			if(call.getName().equals(name) && call.getType()==type)
				return true;
		return false;
	}

	private void selectCharacter() throws ApiException {
		Set<EveCharacter> characters = api.getCharacters();
		if(characters.size() == 1) {
			EveCharacter character = characters.iterator().next();
			System.out.println("Found 1 character: "+character.getName()+"\t\t"+character.getCorporationName());
			System.out.println("The character is automatically selected.");
		} else {
			System.out.println("Found "+characters.size()+" characters:");
			printCharacters(characters);
			System.out.println("Please choose which character you want to use. (enter the characterID");
			EveCharacter character = null;
			while(character == null) {
				String characterIDs = scanner.nextLine();
				long characterID = Long.parseLong(characterIDs);
				character = getCharacter(characterID, characters);
				if(character == null) {
					System.out.println("No correct characterID found. Please choose one of the following characters:");
					printCharacters(characters);
				}
			}
			api.selectCharacter(character);
			System.out.println(character.getName()+" selected.");
		}
	}

	private void printCallList() throws ApiException {
		ApiKeyInfoResponse apiKeyInfo = api.getAPIKeyInfo();
		CallList callList = getCalllList();
		List<Call> calls = new ArrayList<Call>(AccessChecker.getCalls(apiKeyInfo, callList));
		Collections.sort(calls, new Comparator<Call>() {
			public int compare(Call o1, Call o2) {
				if(!o1.getType().equals(o2.getType()))
					return o1.getType().compareTo(o2.getType());
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println("Possible calls:");
		for (Call call : calls) {
			String callName = call.getName();
			int tabs = 3 - (int) Math.floor( callName.length() / 8 );
			System.out.print(callName);
			for(int i=0; i<=tabs; i++) {
				System.out.print("\t");
			}
			System.out.println(call.getType());
		}
	}

	private CallList getCalllList() throws ApiException {
		if(callList == null)
			callList = api.getCallList();
		return callList;
	}

	private void printCharacters(Set<EveCharacter> characters) {
		for (EveCharacter character : characters) {
			System.out.println(character.getCharacterID()+":\t"+character.getName()+"\t\t"+character.getCorporationName());
		}
	}

	private EveCharacter getCharacter(long characterID, Set<EveCharacter> characters) {
		for (EveCharacter character : characters) {
			if(characterID == character.getCharacterID()) {
				return character;
			}
		}
		return null;
	}

}