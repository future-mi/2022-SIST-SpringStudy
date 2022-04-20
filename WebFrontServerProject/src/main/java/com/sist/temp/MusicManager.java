package com.sist.temp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MusicManager {
	public static void main(String[] args) {
		MusicManager m = new MusicManager();
		m.genieMusic();
	}

	public void genieMusic() {
		MusicDAO dao = new MusicDAO();
		try {
			int k = 1;
			for (int i = 1; i <= 2; i++) {
				// HTML을 읽어 와서 메모리 저장
				Document doc = Jsoup.connect("https://www.genie.co.kr/chart/genre?ditc=D&ymd=20220419&genrecode=M0500&pg=" + i).get();
				Elements title = doc.select("td.info a.title");
				Elements singer = doc.select("td.info a.artist");
				Elements album = doc.select("td.info a.albumtitle");
				Elements poster = doc.select("a.cover img");
				Elements etc = doc.select("td.number span.rank"); // state, idcrement

				for (int j = 0; j < title.size(); j++) {
					System.out.println("곡명:" + title.get(j).text());
					System.out.println("가수명:" + singer.get(j).text());
					System.out.println("앨범:" + album.get(j).text());
					System.out.println("포스터:" + poster.get(j).attr("src"));
					
					String tmp = etc.get(j).text();
					String state = tmp.replaceAll("[^가-힣]", "");
					// 10하강, 상승, 유지
					int idcrment = 0;
					if (state.equals("유지")) {
						idcrment = 0;
					} else {
						if (state.equals("상승") || state.equals("하강")) {
							idcrment = Integer.parseInt(tmp.replaceAll("[^0-9]", "").trim());
						} else if (!(state.equals("유지") || state.equals("상승") || state.equals("하강"))) {
							state = "new";
							idcrment = 0;
						}
					}
					System.out.println("상태:" + state);
					System.out.println("등폭:" + idcrment);
					//System.out.println("key:"+getMkeyData(title.get(j).text()));
					System.out.println("=================================");
					
					MusicVO vo = new MusicVO();
					vo.setCno(6);
					vo.setTitle(title.get(j).text());
					vo.setSinger(singer.get(j).text());
					vo.setPoster(poster.get(j).attr("src"));
					vo.setState(state);
					vo.setIdcrement(idcrment);
					vo.setAlbum(album.get(j).text());
					vo.setMkey(getMkeyData(title.get(j).text()));
					dao.musicInsert(vo);
					System.out.println("k=" + k);
					k++;
				}
			}
			System.out.println("저장완료!!");
		} catch (Exception ex) {
		}
	}

	public String getMkeyData(String title) {
		// https://www.youtube.com/results?search_query=%EB%B4%84%EC%97%AC%EB%A6%84%EA%B0%80%EC%9D%84%EA%B2%A8%EC%9A%B8+(still+life)
		String key = "";
		try {
			Document doc = Jsoup.connect("https://www.youtube.com/results?search_query=" + title).get();
			String data = doc.toString();
			// ?는 정규식에서 이미 사용하는 기호 → ?자체를 출력하기 위해서는 \\?
			// ^, +, *, . → \\. \\+
			Pattern p = Pattern.compile("/watch\\?v=[^가-힣]+");
			Matcher m = p.matcher(data);
			while (m.find()) {
				String s = m.group(); // 실제값을 읽어 온다
				// /watch?v=mOLxEqVaRnE","webPageType":"WEB_PAGE_TYPE_WATCH","rootVe":3832}}
				key = s.substring(s.indexOf("=") + 1, s.indexOf("\""));
				break;
			}
		} catch (Exception ex) {
		}
		return key;
	}
}