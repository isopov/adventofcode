package year2017.day1;

public class Part1 {

	static final String INPUT = "5228833336355848549915459366737982598312959583817455621545976784792489468198365998"
			+ "23272273487661233235237619281355294981427594757577433952981197664436151779558699"
			+ "83192422416148136227342557975695715776992385926672874281663982215728858694164196"
			+ "82687759743978434571821267146514338394624525648338739929479912368172669885577319"
			+ "71838927816876684448794876169743872255685788243322439372313129887625262664351723"
			+ "68839991156656569355216757728665161858993171324947167236154934763971156276878876"
			+ "65194781746377341468995954554518252916859227397693885254329628812355612487594445"
			+ "52239585355173456749883838224861613796963797136961544359997358832638879289396992"
			+ "48553164379523134925516715457142627847383435171665441971945471735151559272441754"
			+ "47296474282154114951181648317875827525814453758846194548872789943372281952995222"
			+ "77917381244418649111542647618867225324974447894686331791513683219913286891789124"
			+ "35911957193547211291162291646882568536283392339196714687819131674156242141527938"
			+ "64585332944468428849171876873433621524242289488135675313544498245498637424139153"
			+ "78292572374524972874388549387779264857667319688994956831723412586336918795378861"
			+ "18413883539998755191728963295243465272652317678688396966933282733817727267829491"
			+ "66112932954356923757485139367298699922984925977724972944277991686823219295939734"
			+ "31387483486179617959165917472643235753311389621278156665915493941986679748834744"
			+ "85517194816325722316324635755915996963882233442192283251342332385388542894377563"
			+ "31848887242423387542214691157226725179683638967415678697625138177633444765126223"
			+ "88547834895133263439829161213485285868394246617832992265582222542653435919169617"
			+ "76331679628398479858266769554174266171262882553661231691746743484179321582913346"
			+ "46767637764323226842771523598562429399935789788215958367362467652444854123951972"
			+ "11835841762967945497868733713767549529576845171963199939861782828767193758499869"
			+ "79594258458831457363238182251293118459972149876634333756896217466656291872525116"
			+ "43969315283316269222835744532431378945137649959158495714472963839397214332815241"
			+ "141327714672141875129895";

	public static void main(String... args) {
		System.out.println(sum(
				INPUT));
	}

	public static int sum(String line) {
		int result = 0;
		char[] charArray = line.toCharArray();
		for (int i = 1; i < charArray.length; i++) {
			if (charArray[i - 1] == charArray[i]) {
				result += Integer.valueOf(String.valueOf(charArray[i - 1]));
			}
		}
		if (charArray[0] == charArray[charArray.length - 1]) {
			result += Integer.valueOf(String.valueOf(charArray[0]));
		}
		return result;
	}

}
