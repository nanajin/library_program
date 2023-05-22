package org.example.controller;

import org.example.domain.Library;
import org.example.service.LibraryService;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryController {
    private final LibraryService libraryService;
    Scanner sc;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
        sc = new Scanner(System.in);
    }

    public void start() {
        clearScreen();
        System.out.println("  _____    ____   _                \n" +
                " |  __ \\  / __ \\ | |         /\\    \n" +
                " | |__) || |  | || |        /  \\   \n" +
                " |  ___/ | |  | || |       / /\\ \\  \n" +
                " | |     | |__| || |____  / ____ \\ \n" +
                " |_|      \\____/ |______|/_/    \\_\\\n");

        System.out.print("아무 키나 눌러주세요. ");
        sc.nextLine();
        while (true) {
            menu();
            switch (sc.nextInt()) {
                case 1:
                    insert(bookAdd());
                    break;
                case 2:
                    findAll();
                    break;
                case 3:
                    findByName();
                    break;
                case 4:
                    findByAuthor();
                    break;
                case 5:
                    findByPublisher();
                    break;
                case 6:
                    findByIsbn();
                    break;
                case 7:
                    findByCategory();
                    break;
                case 0:
                    clearScreen();
                    System.out.println("감사합니다.");
                    System.out.println("안녕히 가세요.");
                    return;
            }
        }
    }

    private void findByCategory() {
        clearScreen();
        sc.nextLine();
        System.out.print("카테고리를 입력해주세요: ");
        List<Library> libraryList = libraryService.findByCategory(sc.nextLine());
        if (libraryList.size() == 0)
            libraryNotFound();
        else {
            System.out.println("────────────────────────────────────────────────────────────────────────────────────");
            System.out.printf(" %-3s %-25s %-15s %-8s %-5s %-4s \n", "번호", "책 이름", "저자", "출판사", "출시년도", "권수");
            for (Library library : libraryList) {
                System.out.printf(" %-4s %-25s %-15s %-8s %-8s %-4s \n", library.getId(), library.getName(), library.getAuthor(), library.getPublisher(), library.getReleaseYear() + "년", library.getCount() + "권");
            }
            System.out.println("────────────────────────────────────────────────────────────────────────────────────");

            System.out.print("상세 조회하실 책 번호(메뉴 이동은 -1): ");
            try {
                long id = sc.nextLong();
                if (id != -1)
                    findById(id);
            } catch (Exception ignored) {
            }
        }
    }

    private void menu() {
        clearScreen();
        System.out.println("─────── 도서 관리 프로그램 ────────");
        System.out.println("                           ");
        System.out.println("       1. 도서 등록        ");
        System.out.println("       2. 도서 목록 전체 조회    ");
        System.out.println("       3. 도서 제목으로 검색    ");
        System.out.println("       4. 저자로 검색       ");
        System.out.println("       5. 출판사로 검색      ");
        System.out.println("       6. ISBN으로 검색      ");
        System.out.println("       7. 카테고리로 검색      ");
        System.out.println("       0. 끝내기         ");
        System.out.println("                           ");
        System.out.println("────────────────────────────────");
        System.out.print(" 번호 입력: ");
    }

    private Library bookAdd() {
        clearScreen();
        sc.nextLine();
        System.out.println("=== 도서 등록 ===");
        System.out.print("도서명 : ");
        String name = sc.nextLine();
        System.out.print("작가명 : ");
        String author = sc.nextLine();
        System.out.print("출판사 : ");
        String publisher = sc.nextLine();
        System.out.print("ISBN : ");
        String isbn = sc.nextLine();
        System.out.print("출판년도 : ");
        int releaseYear = sc.nextInt();
        sc.nextLine();
        System.out.print("줄거리 : ");
        String summary = sc.nextLine();
        System.out.print("이미지 : ");
        String image = sc.nextLine();
        System.out.print("카테고리 : ");
        String category = sc.nextLine();
        System.out.print("몇 권을 등록하시겠습니까? : ");
        int count = sc.nextInt();
        sc.nextLine();

        Library lib = new Library(name, author, publisher, isbn, releaseYear, count, summary, image, category);
        return lib;
    }


    private void insert(Library library) {
        libraryService.insert(library);
        clearScreen();
        System.out.println("저장 하였습니다.");
        System.out.println("아무 키나 입력하세요.");
        sc.nextLine();
    }

    private void findByName() {
        clearScreen();
        sc.nextLine();
        System.out.print("도서의 제목을 입력해주세요: ");
        List<Library> libraryList = libraryService.findByName(sc.nextLine());
        if (libraryList.size() == 0)
            libraryNotFound();
        else {
            System.out.println("────────────────────────────────────────────────────────────────────────────────────");
            System.out.printf(" %-3s %-25s %-15s %-8s %-5s %-4s %n", "번호", "책 이름", "저자", "출판사", "출시년도", "권수");
            for (Library library : libraryList) {
                System.out.printf(" %-4s %-25s %-15s %-8s %-7s %-4s %n", library.getId(), library.getName(), library.getAuthor(), library.getPublisher(), library.getReleaseYear() + "년", library.getCount() + "권");
            }
            System.out.println("────────────────────────────────────────────────────────────────────────────────────");

            System.out.print("상세 조회하실 책 번호(메뉴 이동은 -1): ");
            try {
                long id = sc.nextLong();
                if (id != -1)
                    findById(id);
            } catch (Exception ignored) {
            }
        }
    }

    private void detailInfo(Library library) {
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" %-3s %-25s %-15s %-8s %-5s %-4s %-7s %-14s %n", "번호", "책 이름", "저자", "출판사", "출시년도", "권수", "카테고리", "ISBN");
        System.out.printf(" %-3s %-25s %-15s %-8s %-5s %-4s %-7s %-14s %n", library.getId(), library.getName(), library.getAuthor(), library.getPublisher(), library.getReleaseYear() + "년", library.getCount() + "권", library.getCategory(), library.getIsbn());
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    private void getImage(String image) {
        viewer(image);
    }

    private void viewer(String imgUrl) {
        try {
            Desktop.getDesktop().browse(new URI(imgUrl));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void countMinus(Long id) {
        System.out.print("몇 권을 빼시겠습니까: ");
        int count = sc.nextInt();

        libraryService.countMinus(id, count);

        sc.nextLine();
        justFindById(id);

        System.out.println(count + "권을 뺐습니다.");
        System.out.println("아무 키나 입력하세요.");
        sc.nextLine();
    }

    private void countPlus(Long id) {
        System.out.print("몇 권을 더하시겠습니까: ");
        int count = sc.nextInt();

        libraryService.countPlus(id, count);

        sc.nextLine();
        justFindById(id);

        System.out.println(count + "권을 더했습니다.");
        System.out.println("아무 키나 입력하세요.");
        sc.nextLine();
    }

    private void findAll() {
        clearScreen();
        sc.nextLine();
        List<Library> libraryList = libraryService.findAll();

        simpleInfo(libraryList);
    }

    private List<Library> yearSort(List<Library> libraryList) {
        libraryList.sort((y1, y2) -> y2.getReleaseYear() - y1.getReleaseYear());
        return libraryList;
    }

    private List<Library> initialSort(List<Library> libraryList) {
        libraryList.sort(Comparator.comparing(Library::getName));
        return libraryList;
    }

    private void justFindById(Long id) {
        clearScreen();
        Library library = libraryService.findById(id);
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" %-3s %-25s %-15s %-8s %-5s %-4s %-7s %-14s %n", "번호", "책 이름", "저자", "출판사", "출시년도", "권수", "카테고리", "ISBN");
        System.out.printf(" %-4s %-25s %-15s %-8s %-7s %-4s %-8s %-14s %n", library.getId(), library.getName(), library.getAuthor(), library.getPublisher(), library.getReleaseYear() + "년", library.getCount() + "권", library.getCategory(), library.getIsbn());
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        getSummary(library.getSummary());
    }

    private void findById(Long id) {
        clearScreen();
        sc.nextLine();
        Library library = libraryService.findById(id);
        detailInfo(library);
        getSummary(library.getSummary());

        System.out.print("[1] 메뉴   [2] 이미지   [3] 수량 증가   [4] 수량 감소   [5] 수정   [6] 삭제 ");
        switch (sc.nextInt()) {
            case 1:
                return;
            case 2:
                getImage(library.getImage());
                break;
            case 3:
                countPlus(library.getId());
                break;
            case 4:
                countMinus(library.getId());
                break;
            case 5:
                updateForm(library.getId());
                break;
            case 6:
                deleteLibrary(library.getId());
                break;
        }
    }

    private void findByPublisher() {
        clearScreen();
        sc.nextLine();
        System.out.print("검색하실 출판사를 입력하세요: ");
        List<Library> libraryList = libraryService.findByPublisher(sc.nextLine());
        if (libraryList.size() == 0)
            libraryNotFound();
        else {
            System.out.println("────────────────────────────────────────────────────────────────────────────────────");
            System.out.printf(" %-3s %-25s %-15s %-8s %-5s %-4s %n", "번호", "책 이름", "저자", "출판사", "출시년도", "권수");
            for (Library library : libraryList) {
                System.out.printf(" %-4s %-25s %-15s %-8s %-7s %-4s %n", library.getId(), library.getName(), library.getAuthor(), library.getPublisher(), library.getReleaseYear() + "년", library.getCount() + "권");
            }
            System.out.println("────────────────────────────────────────────────────────────────────────────────────");

            System.out.print("상세 조회하실 책 번호(메뉴 이동은 -1): ");
            try {
                long id = sc.nextLong();
                if (id != -1)
                    findById(id);
            } catch (Exception ignored) {
            }
        }
    }

    private void findByIsbn() {
        clearScreen();
        sc.nextLine();
        System.out.print("검색하실 ISBN를 입력하세요: ");
        Library library = libraryService.findByIsbn(sc.nextLine());
        if (library == null)
            libraryNotFound();
        else {
            detailInfo(library);

            System.out.print("[1] 메뉴   [2] 수량 증가   [3] 수량 감소   [4] 수정   [5] 삭제 ");
            switch (sc.nextInt()) {
                case 1:
                    return;
                case 2:
                    countPlus(library.getId());
                    break;
                case 3:
                    countMinus(library.getId());
                    break;
                case 4:
                    updateForm(library.getId());
                    break;
                case 5:
                    deleteLibrary(library.getId());
                    break;
            }
        }
    }

    private void deleteLibrary(long id) {
        libraryService.deleteById(id);
        System.out.println("삭제를 하였습니다.");
        System.out.println("아무 키나 입력하세요.");
        sc.nextLine();
    }

    private void findByAuthor() {
        clearScreen();
        sc.nextLine();
        System.out.print("검색하실 저자를 입력하세요: ");
        List<Library> libraryList = libraryService.findByAuthor(sc.nextLine());
        simpleInfo(libraryList);
    }

    private void simpleInfo(List<Library> libraryList) {
        clearScreen();
        if (libraryList.size() == 0)
            libraryNotFound();
        else {
            System.out.println("────────────────────────────────────────────────────────────────────────────────────");
            System.out.printf(" %-3s %-25s %-15s %-8s %-5s %-4s %n", "번호", "책 이름", "저자", "출판사", "출시년도", "권수");
            for (Library library : libraryList) {
                System.out.printf(" %-4s %-25s %-15s %-7s %-8s %-4s %n", library.getId(), library.getName(), library.getAuthor(), library.getPublisher(), library.getReleaseYear() + "년", library.getCount() + "권");
            }
            System.out.println("────────────────────────────────────────────────────────────────────────────────────");


            System.out.print("[1] 메뉴   [2] 최신순   [3] 이름 정렬   [4] 상세 조회 ");
            switch (sc.nextInt()) {
                case 1:
                    return;
                case 2:
                    simpleInfo(yearSort(libraryList));
                    break;
                case 3:
                    simpleInfo(initialSort(libraryList));
                    break;
                case 4:
                    System.out.print("상세 조회하실 책 번호: ");
                    try {
                        long id = sc.nextLong();
                        if (id != -1)
                            findById(id);
                        break;
                    } catch (Exception ignored) {
                    }
            }
        }
    }

    private void getSummary(String summary) {
        System.out.println("＃줄거리");
        for (int i = 0; i < summary.length(); i++) {
            if (i % 75 == 0) {
                System.out.println();
            }
            System.out.print(summary.charAt(i));
        }
        System.out.println("\n──────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    private void updateForm(long id) {
        System.out.println("=== 도서 수정 ===");
        System.out.print("[1] 줄거리 수정     [2] 이미지 수정    [3] 카테고리 수정    [4]메뉴로 돌아가기    ");

        switch (sc.nextInt()) {
            case 1:
                System.out.print("줄거리 : ");
                sc.nextLine();
                String summary = sc.nextLine();
                libraryService.updateSummary(id, summary);
                justFindById(id);
                System.out.println("수정하였습니다.\n 아무 키나 입력하세요.");
                sc.nextLine();
                break;
            case 2:
                System.out.print("이미지 : ");
                sc.nextLine();
                String image = sc.nextLine();
                libraryService.updateImage(id, image);
                justFindById(id);
                System.out.println("수정하였습니다.\n 아무 키나 입력하세요.");
                sc.nextLine();
                break;
            case 3:
                System.out.print("카테고리 : ");
                sc.nextLine();
                String category = sc.nextLine();
                libraryService.updateCategory(id, category);
                justFindById(id);
                System.out.println("수정하였습니다.\n 아무 키나 입력하세요.");
                sc.nextLine();
                break;
        }
    }

    private void libraryNotFound() {
        System.out.println("조회 결과가 없습니다.");
        System.out.println("아무 키나 입력하세요.");
        sc.nextLine();
    }

    private void clearScreen() {
        for (int i = 0; i < 30; i++)
            System.out.println();
    }
}
