package org.example;

import org.example.controller.LibraryController;
import org.example.domain.Library;
import org.example.repository.LibraryRepositoryImpl;
import org.example.repository.db.ConnectionManager;
import org.example.service.LibraryService;

public class Main {
    public static void main(String[] args) {
        ConnectionManager.getConnection();

        LibraryRepositoryImpl libraryRepository = new LibraryRepositoryImpl();
        LibraryService libraryService = new LibraryService(libraryRepository);
        LibraryController libraryController = new LibraryController(libraryService);

//        init(libraryService);

        libraryController.start();
    }

    public static void init(LibraryService libraryService) {
        libraryService.removeAll();
        libraryService.insert(new Library("흔한남매 1", "백난도", "미래엔", "9791164131686", 2019, 6, "아이돌 가수가 꿈인 초등학교 5학년 여동생 에이미와 그런 동생을 놀리는 재미로 사는 듯한 중학교 2학년 오빠 으뜸이의 일상 이야기는 진짜 웃음이 필요한 어린이들에게 순수한 웃음과 유쾌한 우애를 선사합니다. 웃음을 유발하는 에이미와 으뜸이의 티격태격한 이야기는 물론, 너무 공감돼서 무서운 이야기, 남몰래 서로를 챙겨 주는 남매간의 따뜻한 이야기 등 골라 읽는 재미가 가득한 에피소드 만화가 수록되어 있습니다. 에피소드 만화 중간 중간에는 유튜브에서는 만날 수 없었던 '다른 그림 찾기', '미로 찾기', '영어 난센스 퀴즈', '숨은그림찾기' 등 재미가 가득한 놀이 페이지가 수록되어 있습니다.", "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9791164131686.jpg", "만화/애니메이션"));
        libraryService.insert(new Library("모든 삶은 흐른다", "로랑스 드빌레르", "FIKA", "9791190299770", 2023, 4, "“바다는 인생이다. 무한으로 이어지는 인생.”\n" +
                "바다를 통해 본 인생의 깊이 있는 통찰과 지혜\n" +
                "저자 로랑스 드빌레르는 낯선 ‘인생’을 제대로 ‘항해’하려면 바다를 이해하라고 조언한다. 바다가 우리의 삶과 가장 흡사한 자연이기 때문이다. 바다는 해가 뜨는 곳이자 지는 곳이고, 생이 시작되는 곳이자 끝나는 곳이며, 누군가를 살리기도 하지만 죽이기도 하는 곳이다. 비를 그대로 흡수하며 다 포용하고 받아들일 것 같지만 때때로 거칠게 뱉어내어 경고를 주는 곳, 한결같지만 한결같지 않은 곳, 지구상 어디든 다 연결되어 있지만 가는 곳마다 다른 빛깔로 자신을 내보이는 곳. 저자는 이 모든 게 인생과 닮았다고 말한다.", "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9791190299770.jpg", "인문/철학"));
        libraryService.insert(new Library("챗GPT, 질문이 돈이 되는 세상", "전상훈, 최서연", "미래엔", "9791158741907", 2023, 9, "챗GPT가 바꾸는 세상은 우리의 상상을 뛰어넘는다\n" +
                "국내 최고 미래전략 전문가의\n" +
                "선제적 패러다임 제시!\n" +
                "“챗GPT가 바꾸는 세상\n" +
                "알고 나면 기회가 보인다”\n" +
                "\n" +
                "앞당겨진 특이점,\n" +
                "세상은 과연 어떻게 변하고,\n" +
                "인간은 어떤 방식으로 살아갈 것인가?\n" +
                "\n" +
                "인공지능 시대를 살아야 할 우리는 무엇을 준비해야 하는가?", "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9791158741907.jpg", "경제/경영"));
        libraryService.insert(new Library("아몬드", "손원평", "반양장", "9788936456788", 2017, 6, "감정 표현 불능증을 앓고 있는 열여섯 살 소년 선윤재. ‘아몬드’라 불리는 편도체가 작아 분노도 공포도 잘 느끼지 못하는 그는 타고난 침착성, 엄마와 할머니의 지극한 사랑 덕에 별 탈 없이 지냈지만 크리스마스이브이던 열여섯 번째 생일날 벌어진 비극적인 사고로 가족을 잃는다. 그렇게 세상에 홀로 남겨진 윤재 앞에 ‘곤이’가 나타난다. 놀이동산에서 엄마의 손을 잠깐 놓은 사이 사라진 후 13년 만에 가족의 품으로 돌아오게 된 곤이는 분노로 가득 찬 아이다. 곤이는 윤재를 괴롭히고 윤재에게 화를 쏟아 내지만, 감정의 동요가 없는 윤재 앞에서 오히려 쩔쩔매고 만다. 그 후 두 소년은 남들이 이해할 수 없는 특별한 우정을 쌓아가고, 윤재는 조금씩 내면의 변화를 겪는데……", "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788936456788.jpg", "청소년소설"));
        libraryService.insert(new Library("체리새우: 비밀글입니다", "황영미", "문학동네", "9788954654753", 2019, 8, "사람들은 나를 어떻게 생각하고 있을까, 나는 지금 어떻게 보일까, 나를 싫어하면 어쩌지. 타인의 시선에 흔들리고 또 흔들리다가 진짜 ‘나'를 감추고 만 경험이 누구에게나 있을 것이다. 특히 학교라는 폐쇄적인 공간에서 어떻게든 원만하게 친구 관계를 유지해야 하고 어떻게든 ‘따’가 되지 않아야만 하는 청소년들에게, 진짜 나 자신을 내세우는 일은 익숙하지 않을 수밖에 없다. 『체리새우: 비밀글입니다』는 지금 이 순간에도 ‘우리’의 세계에 속하기 위해 ‘나’를 감추고 있을 청소년들에게 건네는 공감의 말이자 든든한 응원의 외침이다.", "https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9788954654753.jpg", "청소년소설"));
    }
}