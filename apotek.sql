-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 18 Feb 2023 pada 08.23
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apotek`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barangmasuk`
--

CREATE TABLE `barangmasuk` (
  `id` int(11) NOT NULL,
  `kdo` varchar(100) NOT NULL,
  `supp` varchar(100) NOT NULL,
  `tgl` varchar(255) NOT NULL,
  `stok` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barangmasuk`
--

INSERT INTO `barangmasuk` (`id`, `kdo`, `supp`, `tgl`, `stok`) VALUES
(12, 'AA2121', '1955', '2022-06-01', 97),
(13, 'MK3212', '1955', '2022-07-02', 96),
(14, 'OB8856', '1955', '2022-07-03', 98);

-- --------------------------------------------------------

--
-- Struktur dari tabel `isi`
--

CREATE TABLE `isi` (
  `id_nota` varchar(255) NOT NULL,
  `kd_obat` varchar(255) NOT NULL,
  `harga` int(255) NOT NULL,
  `qty` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `isi`
--

INSERT INTO `isi` (`id_nota`, `kd_obat`, `harga`, `qty`) VALUES
('IN0001', 'MK3212', 20000, 2),
('IN0001', 'AA2121', 30000, 3),
('IN0002', 'MK3212', 20000, 2),
('IN0002', 'OB8856', 25000, 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `idky` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `TG` varchar(25) NOT NULL,
  `JK` varchar(25) NOT NULL,
  `email` varchar(60) NOT NULL,
  `nohp` varchar(20) NOT NULL,
  `agama` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`idky`, `nama`, `TG`, `JK`, `email`, `nohp`, `agama`, `password`) VALUES
('1212', 'dieto', '2001-08-18', 'Laki-Laki', 'mendeito@gmial.com', '085714903209', 'Islam', 'matic'),
('3453', 'ganang', '2000-07-14', 'Laki-Laki', 'ganan@gmail.com', '12131231333', 'Islam', 'ganang'),
('fauzi', 'Fauzi Rahman', '2001-09-03', 'Laki-Laki', 'fauzi@gmail.com', '089602962783', 'Islam', '030901');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`id`, `nama`) VALUES
(1, 'OBAT JAMU'),
(2, 'OBAT BEBAS'),
(3, 'OBAT BEBAS TERBATAS'),
(4, 'OBAT HERBAL TERSTANDAR'),
(5, 'OBAT KERAS'),
(6, 'FITOFARMAKA'),
(7, 'OBAT JENIS NARKOTIKA');

-- --------------------------------------------------------

--
-- Struktur dari tabel `nota`
--

CREATE TABLE `nota` (
  `id_nota` varchar(255) NOT NULL,
  `tgl_nota` varchar(255) NOT NULL,
  `id` varchar(255) NOT NULL,
  `idky` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `nota`
--

INSERT INTO `nota` (`id_nota`, `tgl_nota`, `id`, `idky`) VALUES
('IN0001', '2022-07-02', '221021', '1212'),
('IN0002', '2022-07-05', '221021', 'fauzi');

-- --------------------------------------------------------

--
-- Struktur dari tabel `obat`
--

CREATE TABLE `obat` (
  `kd_obat` varchar(15) NOT NULL,
  `nm_obat` varchar(100) NOT NULL,
  `jenis_obat` varchar(30) NOT NULL,
  `satuan` varchar(20) NOT NULL,
  `harga` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `obat`
--

INSERT INTO `obat` (`kd_obat`, `nm_obat`, `jenis_obat`, `satuan`, `harga`) VALUES
('AA2121', 'Ardium', '5', 'Strip', 30000),
('MK3212', 'Minyak Kayu Putih', '4', 'Botol', 20000),
('OB8856', 'OBH Combi', '4', 'Botol', 25000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id` varchar(6) NOT NULL,
  `nmplg` varchar(25) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `telepon` varchar(20) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id`, `nmplg`, `jenis`, `telepon`, `alamat`) VALUES
('187654', 'habib', 'Laki-Laki', '123312233321', 'ragunan'),
('221021', 'fauzi', 'Laki-Laki', '082276542215', 'bekasi jati asih'),
('884567', 'reto', 'Laki-Laki', '223123141241', 'pedurena pasar rebo'),
('9012', 'bagas', 'Laki-Laki', '08456678543', 'pasar minggu');

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `kpt` varchar(255) NOT NULL,
  `npt` varchar(255) NOT NULL,
  `tgl` varchar(255) NOT NULL,
  `apt` varchar(255) NOT NULL,
  `tpt` varchar(255) NOT NULL,
  `ept` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`kpt`, `npt`, `tgl`, `apt`, `tpt`, `ept`) VALUES
('1955', 'AVCC', '2017-06-08', 'kuningan', '122231232', 'AVCC@gmail.com'),
('8845', 'danon', '2017-06-08', 'kuningan', '122231231', 'danon@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barangmasuk`
--
ALTER TABLE `barangmasuk`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`idky`);

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`id_nota`);

--
-- Indeks untuk tabel `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`kd_obat`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`kpt`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `barangmasuk`
--
ALTER TABLE `barangmasuk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
