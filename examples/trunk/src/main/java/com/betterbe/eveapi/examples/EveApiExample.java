package com.betterbe.eveapi.examples;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.beimin.eveapi.EveApi;
import com.beimin.eveapi.account.characters.EveCharacter;
import com.beimin.eveapi.api.calllist.Call;
import com.beimin.eveapi.api.calllist.CallGroup;
import com.beimin.eveapi.api.calllist.CallList;
import com.beimin.eveapi.core.ApiAuthorization;
import com.beimin.eveapi.exception.ApiException;

public class EveApiExample extends Thread {

	public static void main(String[] args) {
		EveApiExample example = new EveApiExample();
		example.start();
	}
	
	@Override
	public void run() {
		Scanner scanIn = new Scanner(System.in);
		try {
			System.out.println("Please enter a keyID: ");
			String keyIDs = scanIn.nextLine();
			int keyID = Integer.parseInt(keyIDs);
	
			System.out.println("Please enter the verification code: ");
			String vCode = scanIn.nextLine();
			EveApi api = new EveApi(new ApiAuthorization(keyID, vCode));
			System.out.println("EveApi initialized... retrieving character list associated with the api key.");
			Set<EveCharacter> characters;
				characters = api.getCharacters();
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
					String characterIDs = scanIn.nextLine();
					long characterID = Long.parseLong(characterIDs);
					character = getCharacter(characterID, characters);
					if(character == null) {
						System.out.println("No correct characterID found. Please choose one of the following characters:");
						printCharacters(characters);
					}
				}
				api.selectCharacter(character);
				System.out.println(character.getName()+" selected.");
				CallList callList = api.getCallList();
				List<CallGroup> callGroups = callList.getCallGroups();
				System.out.println("Possible calls:");
				for (CallGroup callGroup : callGroups) {
					System.out.println("\n=== "+callGroup.getName()+" ===");
					List<Call> calls = callGroup.getCalls();
					Collections.sort(calls, new Comparator<Call>() {
						public int compare(Call o1, Call o2) {
							if(!o1.getType().equals(o2.getType()))
								return o1.getType().compareTo(o2.getType());
							return o1.getName().compareTo(o2.getName());
						}
					});
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
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		scanIn.close();
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