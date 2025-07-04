import java.io.*;
import java.util.*;;

public class FileManager {
            public static void main(String[] args) {
                //        File file = new File();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Fayloviy menedzher zapushen");

                while (true) {
                    System.out.print("\nVvedite komandu: ");
                    String input = scanner.nextLine();
                    String[] parts = input.trim().split("\\s+");

                    if (parts.length == 0) continue;
                    String command = parts[0];

                    try {
                        switch (command) {
                            case "create-folder":
                                if (parts.length < 2) {
                                    System.out.println("Ukazhite put");
                                } else {
                                    createNestedFolders(parts[1], 1);
                                }
                                break;

                            case "create-file":
                                if (parts.length < 2) {
                                    System.out.println("Ukazhite put");
                                } else {
                                    createFile(parts[1]);
                                }
                                break;

                            case "delete":
                                if (parts.length < 2) {
                                    System.out.println("Ukazhite put");
                                } else if (parts.length == 3 && parts[1].equals("r")) {
                                    recursiveDeleteFolder(new File(parts[2]));
                                } else {
                                    deleteFileOrEmptyFolder(new File(parts[1]));
                                }
                                break;

                            case "rename":
                                if (parts.length < 3) {
                                    System.out.println("Ukazhite staroe i novoe imya");
                                } else {
                                    rename(parts[1], parts[2]);
                                }
                                break;

                            case "move":
                                if (parts.length < 3) {
                                    System.out.println("Ukazhite otkuda i kuda");
                                } else {
                                    move(parts[1], parts[2]);
                                }
                                break;

                            case "list":
                                if (parts.length < 2) {
                                    System.out.println("Ukazhite put");
                                } else {
                                    listFilesAndFolders(new File(parts[1]));
                                }
                                break;

                            case "size":
                                if (parts.length < 2) {
                                    System.out.println("Ukazhite put");
                                } else {
                                    long size = getSize(new File(parts[1]));
                                    System.out.println("Razmer: " + size + " byte");
                                }
                                break;

                            case "sort":
                                if (parts.length < 2) {
                                    System.out.println("Ukazhite put");
                                } else {
                                    String sortBy = parts.length == 3 ? parts[2] : "name";
                                    sortFolder(new File(parts[1]), sortBy);
                                }
                                break;

                            case "exit":
                                System.out.println("Vihod iz programmy");
                                return;

                            default:
                                System.out.println("Neizvestnaya komanda");
                        }
                    } catch (Exception e) {
                        System.out.println("Oshibka: " + e.getMessage());
                    }
                }
            }

            public static void createNestedFolders(String root, int count) {
                createNestedFoldersHelper(root, 0, count);
            }

            public static void createNestedFoldersHelper(String path, int current, int max) {
                if (current >= max) {
                    return;
                }

                File folder = new File(path, "Folder_" + current);
                if (folder.mkdir()) {
                    System.out.println("Sozdana papka " + folder.getName());
                    createNestedFoldersHelper(folder.getAbsolutePath(), current + 1, max);
                } else {
                    System.out.println("Oshibka pri sozdanii " + folder.getAbsolutePath());
                }
            }

            public static void listFolders(File directory, int lvl, int max) {
                if (max == 0) return;
                if (!directory.isDirectory()) return;

                System.out.println(" ".repeat(lvl * 4) + (lvl == 0 ? directory.getAbsolutePath() : "|-- " + directory.getName()));
                File[] subFolders = directory.listFiles(File::isDirectory);
                if (subFolders != null) {
                    for (File folder : subFolders) {
                        listFolders(folder, lvl + 1, max - 1);
                    }
                }
            }

            public static void recursiveDeleteFolder(File folder) {
                if (!folder.exists()) {
                    System.out.println("Papka ne sushchestvuet");
                    return;
                }

                File[] files = folder.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            recursiveDeleteFolder(file);
                        } else {
                            if (file.delete()) {
                                System.out.println("Udalil file: " + file.getName());
                            } else {
                                System.out.println("Ne udalos udalit file: " + file.getAbsolutePath());
                            }
                        }
                    }
                }

                if (folder.delete()) {
                    System.out.println("Papka udalena");
                } else {
                    System.out.println("Ne udalos udalit papku: " + folder.getAbsolutePath());
                }
            }

            public static void createFile(String path) {
                File file = new File(path);
                if (file.exists()) {
                    System.out.println("File uzhe sushchestvuet");
                    return;
                }
                try {
                    if (file.createNewFile()) {
                        System.out.println("File sozdano: " + file.getAbsolutePath());
                    } else {
                        System.out.println("Oshibka pri sozdanii file");
                    }
                } catch (IOException e) {
                    System.out.println("Oshibka: " + e.getMessage());
                }
            }

            public static void deleteFileOrEmptyFolder(File file) {
                if (!file.exists()) {
                    System.out.println("Fail ili papka ne naydeny");
                    return;
                }
                if (file.delete()) {
                    System.out.println("Uspeshno udaleno: " + file.getAbsolutePath());
                } else {
                    System.out.println("Ne udalos udalit: " + file.getAbsolutePath());
                }
            }

            public static void rename(String oldPath, String newPath) {
                File oldFile = new File(oldPath);
                File newFile = new File(newPath);
                if (!oldFile.exists()) {
                    System.out.println("Istochnik ne nayden");
                    return;
                }
                if (oldFile.renameTo(newFile)) {
                    System.out.println("Uspeshno pereimenovano");
                } else {
                    System.out.println("Oshibka pri pereimenovanii");
                }
            }

            public static void move(String fromPath, String toPath) {
                File source = new File(fromPath);
                File dest = new File(toPath);
                if (!source.exists()) {
                    System.out.println("Istochnik ne nayden");
                    return;
                }
                if (source.renameTo(dest)) {
                    System.out.println("Uspeshno peremeshcheno");
                } else {
                    System.out.println("Oshibka pri peremeshchenii");
                }
            }

            public static long getSize(File file) {
                if (!file.exists()) return 0;

                if (file.isFile()) {
                    return file.length();
                }

                long size = 0;
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        size += getSize(f);
                    }
                }
                return size;
            }

            public static void listFilesAndFolders(File directory) {
                if (!directory.exists() || !directory.isDirectory()) {
                    System.out.println("Papka ne naydena");
                    return;
                }File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        System.out.println((file.isDirectory() ? "[DIR] " : "[FILE] ") + file.getName());
                    }
                }
            }

            public static void sortFolder(File directory, String sortBy) {
                if (!directory.exists() || !directory.isDirectory()) {
                    System.out.println("Papka ne naydena");
                    return;
                }

                File[] files = directory.listFiles();
                if (files == null) return;

                if (sortBy.equalsIgnoreCase("size")) {
                    Arrays.sort(files, Comparator.comparingLong(FileManager::getSize));
                } else {
                    Arrays.sort(files, Comparator.comparing(File::getName));
                }

                for (File file : files) {
                    System.out.println((file.isDirectory() ? "[DIR] " : "[FILE] ")
                            + file.getName() + " (" + getSize(file) + " byte)");
                }
            }
        }
